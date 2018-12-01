package server;

import org.apache.thrift.TException;
import search.MessagePackage;
import search.RMOperation;
import search.RemovePakcage;
import search.Search;
import shared.SharedStruct;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.BlockingQueue;

import static search.Operation.REPORT;
import static server.JavaServer.OUTPUT_PATH;

public class SearchHandler implements Search.Iface {

  private volatile HashMap<Integer,SharedStruct> log;

  private volatile Map<Integer, LengthCounter> cntMap = new HashMap<>();

  private volatile BlockingQueue<MessagePackage> queue;

  private volatile BlockingQueue<RemovePakcage> rmQueue;

  private volatile Map<Integer, Double> betweenEdge = new HashMap<>();

  private volatile Set<Integer> notificated = new HashSet<>();

  private volatile int notificationCount = 0;

  private volatile double maxBetweenness = 0.0;

  private volatile Set<List<Integer>> edges = new HashSet<>();

  private volatile Set<Integer> allNodes = new HashSet<>();

  private volatile Map<List<Integer>, EdgeItem> edgeBetween = new HashMap<>();

  private volatile int id;

  private volatile List<Integer> nei;

  private volatile boolean isTerminated = false;

  private volatile int confirmationCount = 0;

  private volatile boolean startWaiting = false;


  private PriorityQueue<EdgeItem> heap = new PriorityQueue<EdgeItem>((a, b) -> {
    if (a.between != b.between) {
      return Double.compare(b.between, a.between);
    }
    for (int i = 0; i < a.edge.size(); i++) {
      if (a.edge.get(i) == b.edge.get(i)) continue;
      return b.edge.get(i) - a.edge.get(i);
    }
    return 0;
  });


  public SearchHandler(int id, List<Integer> nei, BlockingQueue<MessagePackage> queue, BlockingQueue<RemovePakcage> rmQueue) {
    log = new HashMap<>();
    this.id = id;
    this.nei = nei;
    this.queue = queue;
    this.rmQueue = rmQueue;
  }

  public void ping() {
//    System.out.println("ping() " + id);
  }

  @Override
  public void search(MessagePackage msg) throws TException {
    System.out.println("search(" + id + "), from(" + msg.fromId+ ") len:" + msg.len + " cnt:"  + msg.cnt +  ", origin:" + msg.id + ", op:" + msg.op + ", between:" + msg.between + " edge:" + msg.edge);
//    System.out.println("id:" + id + ", betweenness:" + betweenEdge);
    if (!cntMap.containsKey(msg.id)) {
      cntMap.put(msg.id, new LengthCounter());
    }

    switch (msg.op){
      case SEARCH:
        acceptSearching(msg);
        break;
      case REPORT:
        acceptReport(msg);
        checkTerminate(msg);
        break;
      default:

    }

    System.out.println(id + "|" + cntMap);

    logEvent(msg);
  }

  @Override
  public void remove(RemovePakcage msg) throws TException {
    System.out.println("remove(" + id + "), from(" + msg.id+ ") len:" + ", op:" + msg.op + ", between:" + msg.between);

    switch (msg.op) {
      case NOTIFICATION:
        acceptNotification(msg);
        break;
      case CONFIRM:
        confirmationCount++;
        System.out.println("confirm:[" + id + "]|" + confirmationCount);
        if (confirmationCount == allNodes.size()) {
          if (isTerminated) {
            sendDelete();
          }
        }
        break;
      default:

    }
  }

  private void acceptNotification(RemovePakcage msg) {
    Set<EdgeItem> set = new HashSet<>();
    for (List<Integer> key : msg.between.keySet()) {
      EdgeItem edgeItem = new EdgeItem();
      edgeItem.edge = key;
      edgeItem.between = msg.between.get(key);
      set.add(edgeItem);
    }
    if (!notificated.contains(msg.id)) {
      notificated.add(msg.id);
      notificationCount++;
      set.stream().forEach(edgeItem -> {
        if (edgeBetween.containsKey(edgeItem.edge)) {
            if (edgeBetween.get(edgeItem.edge).between < edgeItem.between) {
              heap.remove(edgeBetween.get(edgeItem.edge));
              edgeBetween.put(edgeItem.edge, edgeItem);
            }
        }
        else {
          edgeBetween.put(edgeItem.edge, edgeItem);
        }
      });
      heap.addAll(set);
      maxBetweenness = heap.peek().between;
    }
    if (notificationCount == allNodes.size()) {
      while (!heap.isEmpty() && heap.peek().between == maxBetweenness) {
        EdgeItem edgeItem = heap.poll();
        System.out.println("Pop edge:" + edgeItem + ", with heap:" + heap);
        deleteEdge(edgeItem);
      }
      dumpOutput();
      System.out.println(id + "| EXIT!!!!");
    }
  }

  private void dumpOutput() {
      StringBuilder str = new StringBuilder();
      for (int n : nei) str.append(n).append(" ");
      byte[] bytes = str.toString().getBytes();
      try (OutputStream out = new FileOutputStream(OUTPUT_PATH + "/" + id, false)) {
        out.write(bytes);
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  private void deleteEdge(EdgeItem edgeItem) {
    int neighbor = id == edgeItem.edge.get(0) ? edgeItem.edge.get(1) : edgeItem.edge.get(0);
    Set<Integer> result = new HashSet<>();
    result.addAll(nei);
    if (result.contains(neighbor)) {
      result.remove(neighbor);
      System.out.println(id + "|###Delete neighbor " + neighbor + "nei:" + result);
    }
    nei.clear();
    nei.addAll(result);
  }

  private void checkTerminate(MessagePackage msg) {
    int cnt = 0;
    LengthCounter lc = cntMap.get(msg.id);
    for (int n : nei) {
      if (lc.parents.contains(n) || lc.reported.contains(n))
          continue;
      cnt++;
    }
    if (cnt == 0) {
        isTerminated = true;
        System.out.println(id + "!################### Terminate!" + betweenEdge + ", seen vertices:" + allNodes);
//        sendDelete();
        if (id == msg.id)
          sendConfirmation();
    }
  }

  private void sendConfirmation() {
    for (int n : allNodes) {
      RemovePakcage removePakcage = new RemovePakcage();
      removePakcage.id = id;
      removePakcage.op = RMOperation.CONFIRM;
      removePakcage.to = n;
      sendMessage(removePakcage);
      System.out.println("id:"+id +"send confirm:" + removePakcage);
    }
    if (confirmationCount == allNodes.size()) {
      sendDelete();
    }
  }

  private void acceptReport(MessagePackage msg) {
    LengthCounter lc = cntMap.get(msg.id);
    if (lc.parents.contains(msg.fromId))
      lc.parents.remove(msg.fromId);

    this.allNodes.addAll(msg.seenVertices);
    if (allNodes.contains(id))
      allNodes.remove(id);

    lc.reported.add(msg.fromId);

    if (!lc.edgeSet.contains(msg.edge)) {
      lc.edgeSet.add(msg.edge);
      lc.fluid += msg.between;
      int neighbor = id == msg.edge.get(0) ? msg.edge.get(1) : msg.edge.get(0);
      lc.between.put(neighbor, msg.between);
    }

    int reportedCntAndParentsCnt = 0;

    for (int n : nei) {
      if (lc.parents.contains(n) || lc.reported.contains(n) || (lc.seenD.containsKey(n) && lc.seenD.get(n) - 1 == lc.length))
        continue;
      reportedCntAndParentsCnt++;
    }

    if (reportedCntAndParentsCnt == 0)
      sendReport(msg);

  }

  private void computeBetween() {
    System.out.println(id+"$$$[l"+cntMap);
    for (int key : cntMap.keySet()) {
      LengthCounter lc = cntMap.get(key);
//      System.out.println("$$$[lkkk"+lc.edgeSet);
      lc.edgeSet.stream().filter(edge -> !edges.contains(edge))
              .forEach(edge -> {
                edges.add(edge);
        int neighbor = id == edge.get(0) ? edge.get(1) : edge.get(0);
        if (!betweenEdge.containsKey(neighbor))
          betweenEdge.put(neighbor, 0.0);
        betweenEdge.put(neighbor, betweenEdge.get(neighbor) + lc.between.get(neighbor));
      });
    }
  }

  private void generateReport(MessagePackage msg, LengthCounter lc, double f, int n) {
    msg.op = REPORT;
    msg.between = f * lc.contr.get(n);
    msg.edge = new ArrayList<>();
    msg.edge.add(id);
    msg.edge.add(n);
    if (msg.seenVertices == null)
      msg.seenVertices = new HashSet<>();
    msg.seenVertices.add(id);
    msg.seenVertices.addAll(lc.seenD.keySet());
    msg.seenVertices.addAll(lc.dist.keySet());

    lc.between.put(id, msg.between);

    Collections.sort(msg.edge);
    msg.edge.add(msg.id);

    if (!lc.edgeSet.contains(msg.edge)) {
      lc.edgeSet.add(msg.edge);
      int neighbor = id == msg.edge.get(0) ? msg.edge.get(1) : msg.edge.get(0);
      lc.between.put(neighbor, msg.between);
    }
  }

  private double computeFluid(LengthCounter lc) {
      int sum = 0;
      for (int key : lc.contr.keySet()) {
        sum += lc.contr.get(key);
      }
      return (lc.fluid + 1.0) / sum;
  }

  private void sendMessage(MessagePackage msg, int n) {
    try {
      msg.to = n;
      msg.fromId = id;

      queue.put(new MessagePackage(msg));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  private void setDist(MessagePackage msg, LengthCounter lc, int fromId) {
    if (!lc.seenD.containsKey(fromId)) {
      lc.seenD.put(fromId, Integer.MAX_VALUE);
    }
    int d = lc.seenD.get(fromId);
    if (d > msg.len) {
      lc.seenD.put(fromId, msg.len);
    }
  }

  private void acceptSearching(MessagePackage msg) {
    LengthCounter lc = cntMap.get(msg.id);
    setDist(msg, lc, msg.fromId);
    if (msg.len < lc.length) {
      lc.parents.clear();
      lc.parents.add(msg.fromId);

      lc.length = msg.len;
      lc.cnt = msg.cnt;

      lc.dist.put(msg.fromId, msg.len);
      lc.contr.put(msg.fromId, msg.cnt);

      msg.len++;
      sendUpdate(msg, msg.fromId, lc);
    }
    else if (msg.len == lc.length && (!lc.dist.containsKey(msg.fromId))
            ||(lc.contr.containsKey(msg.fromId) && lc.contr.get(msg.fromId) < msg.cnt)) {
      int diff = msg.cnt - lc.contr.getOrDefault(msg.fromId, 0);
      lc.cnt += diff;
      System.out.println("cnt:" + lc.cnt + " diff:" + diff + "id|" + id);

      lc.dist.put(msg.fromId, msg.len);
      lc.contr.put(msg.fromId, msg.cnt);
      msg.cnt = lc.cnt;

      lc.parents.add(msg.fromId);

      msg.len++;
      sendUpdate(msg, msg.fromId, lc);
    }

    int cnt = 0;
    for (int n : this.nei) {
      if (lc.parents.contains(n) ||lc.reported.contains(n)|| (lc.seenD.containsKey(n) && lc.seenD.get(n) - 1 == lc.length))
        continue;
      cnt++;
    }
    if (cnt == 0) {
      if (!startWaiting) {
        startWaiting = true;
        Runnable run = () -> {
          System.out.println("\n\n\n\n\n\n\n\n\n\n");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          sendReport(msg);
        };

        new Thread(run).start();
      }
    }
  }


  private void sendReport(MessagePackage  inputMsg) {
      LengthCounter lc = cntMap.get(inputMsg.id);
    System.out.println("cntmap in thread:" + cntMap);
    MessagePackage msg = new MessagePackage(inputMsg);
    msg.cnt = lc.cnt;
    System.out.println("msg cnt:" + msg.cnt);
      for (int n : lc.parents) {
        generateReport(msg, lc, computeFluid(lc), n);
        sendMessage(msg, n);
      }
//      computeBetween();
  }

  private void sendDelete() {
    double max = 0;
    for (int key : betweenEdge.keySet()) {
      max = Math.max(max, betweenEdge.get(key));
    }

    Map<List<Integer>, Double> between = new HashMap<>();

    for (int key : betweenEdge.keySet()) {
      if (betweenEdge.get(key) == max) {
          List<Integer> edge = new ArrayList<>();
          edge.add(id);
          edge.add(key);
          Collections.sort(edge);
          edge.add(id);
          between.put(edge, max);
      }
    }

    for (int n : allNodes) {
      RemovePakcage removePakcage = new RemovePakcage();
      removePakcage.id = id;
      removePakcage.between = between;
      removePakcage.op = RMOperation.NOTIFICATION;
      removePakcage.to = n;
      sendMessage(removePakcage);
    }
  }

  private void sendMessage(RemovePakcage removePakcage) {
    try {
      rmQueue.put(new RemovePakcage(removePakcage));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void logEvent(MessagePackage msg) {
    SharedStruct entry = new SharedStruct();
    entry.key = id;
    entry.value = msg.id + "|" + msg.len;
    log.put(id, entry);
  }

  private void sendUpdate(MessagePackage msg, int from, LengthCounter lc) {
    for (int n : this.nei) {
      if (lc.parents.contains(n))
        continue;
      sendMessage(msg, n);
    }
  }

  public SharedStruct getStruct(int key) {
    return log.get(key);
  }

  class LengthCounter {
    public volatile int length;
    public volatile int cnt;
    public volatile Set<Integer> parents = new HashSet<>();
    public volatile Map<Integer, Integer> dist = new HashMap<>();
    public volatile Map<Integer, Integer> seenD = new HashMap<>();
    public volatile Map<Integer, Integer> contr = new HashMap<>();
    public volatile Set<Integer> reported = new HashSet<>();
    public volatile double fluid = 0.0;
    public volatile Set<List<Integer>> edgeSet = new HashSet<>();

    public volatile  Map<Integer, Double> between = new HashMap<>();


    public LengthCounter() {
      this.length = Integer.MAX_VALUE;
      cnt = 0;
    }
    @Override
    public String toString() {
      return "len:" + this.length + ", cnt:" + this.cnt + ", dist:" + dist + ", r1eported" + reported + ", parent:" + parents
              + " contribute:" + contr + " fluid:" + fluid + " between:" + between + ", edge:" + edgeSet + " seenD:" + seenD;
    }
  }

  class EdgeItem {
    public List<Integer> edge;
    public double between;
    @Override
    public String toString() {
        return "edges:" + edge + ", between:" + between;
    }
  }
}


package server;

import org.apache.thrift.TException;
import search.MessagePackage;
import search.Search;
import shared.SharedStruct;

import java.util.*;
import java.util.concurrent.BlockingQueue;

import static search.Operation.REPORT;

public class SearchHandler implements Search.Iface {

  private HashMap<Integer,SharedStruct> log;

  private Map<Integer, LengthCounter> cntMap = new HashMap<>();

  private BlockingQueue<MessagePackage> queue;

  private Map<Integer, Double> betweenEdge = new HashMap<>();

  private Set<List<Integer>> edges = new HashSet<>();

  private int id;
  public List<Integer> nei;

  public SearchHandler(int id, List<Integer> nei, BlockingQueue<MessagePackage> queue) {
    log = new HashMap<>();
    this.id = id;
    this.nei = nei;
    this.queue = queue;
  }

  public void ping() {
//    System.out.println("ping() " + id);
  }

  @Override
  public void search(MessagePackage msg) throws TException {
    System.out.println("search(" + id + "), from(" + msg.fromId+ ") len:" + msg.len + ", origin:" + msg.id + ", op:" + msg.op + ", between:" + msg.between + " edge:" + msg.edge);
    System.out.println("id:" + id + ", betweenness:" + betweenEdge);
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

  private void checkTerminate(MessagePackage msg) {
    int cnt = 0;
    LengthCounter lc = cntMap.get(msg.id);
    for (int n : nei) {
      if (lc.parents.contains(n) || lc.reported.contains(n))
          continue;
      cnt++;
    }
  }

  private void acceptReport(MessagePackage msg) {
    LengthCounter lc = cntMap.get(msg.id);
    if (lc.parents.contains(msg.fromId))
      lc.parents.remove(msg.fromId);

    lc.reported.add(msg.fromId);

    if (!lc.edgeSet.contains(msg.edge)) {
      lc.edgeSet.add(msg.edge);
      lc.fluid += msg.between;
      int neighbor = id == msg.edge.get(0) ? msg.edge.get(1) : msg.edge.get(0);
      lc.between.put(neighbor, msg.between);
    }

    int reportedCntAndParentsCnt = 0;

    for (int n : nei) {
      if (lc.parents.contains(n) || lc.reported.contains(n) || (lc.dist.containsKey(n) && lc.dist.get(n) - 1 == lc.length))
        continue;
      reportedCntAndParentsCnt++;
    }

    if (reportedCntAndParentsCnt == 0)
      sendReport(msg, lc, reportedCntAndParentsCnt);

  }

  private void computeBetween() {
    System.out.println("$$$[l"+cntMap);
    for (int key : cntMap.keySet()) {
      LengthCounter lc = cntMap.get(key);
      System.out.println("$$$[lkkk"+lc.edgeSet);
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
      return (lc.fluid + 1.0) / lc.parents.size();
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

  private void acceptSearching(MessagePackage msg) {
    LengthCounter lc = cntMap.get(msg.id);
    setDist(msg, lc, msg.fromId);
    if (msg.len < lc.length) {
      lc.parents.clear();
      lc.parents.add(msg.fromId);

      lc.length = msg.len;
      lc.cnt = msg.cnt;

      msg.len++;
      sendUpdate(msg, msg.fromId, lc);

    }
    else if (msg.len == lc.length) {
      lc.cnt += msg.cnt;
      msg.cnt = lc.cnt;

      lc.parents.add(msg.fromId);

      msg.len++;
      sendUpdate(msg, msg.fromId, lc);
    }
    int cnt = 0;
    for (int n : this.nei) {
      if (lc.parents.contains(n) ||lc.reported.contains(n)|| (lc.dist.containsKey(n) && lc.dist.get(n) - 1 == lc.length))
        continue;
      cnt++;
    }
    if (cnt == 0)
      sendReport(msg, lc, cnt);
  }

  private void sendReport(MessagePackage msg, LengthCounter lc, int cnt) {
      for (int n : lc.parents) {
        generateReport(msg, lc, computeFluid(lc), n);
        sendMessage(msg, n);
      }
      computeBetween();
      System.out.println(id + "!################### Terminate!" + betweenEdge);
  }

  private void setDist(MessagePackage msg, LengthCounter lc, int fromId) {
    if (!lc.dist.containsKey(fromId)) {
      lc.dist.put(fromId, Integer.MAX_VALUE);
    }
    int d = lc.dist.get(fromId);
    if (d > msg.len) {
      lc.dist.put(fromId, msg.len);
      lc.contr.put(fromId, msg.cnt);
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
    public int length;
    public int cnt;
    public Set<Integer> parents = new HashSet<>();
    public Map<Integer, Integer> dist = new HashMap<>();
    public Map<Integer, Integer> contr = new HashMap<>();
    public Set<Integer> reported = new HashSet<>();
    public double fluid = 0.0;
    public Set<List<Integer>> edgeSet = new HashSet<>();

    public Map<Integer, Double> between = new HashMap<>();


    public LengthCounter() {
      this.length = Integer.MAX_VALUE;
      cnt = 0;
    }
    @Override
    public String toString() {
      return "len:" + this.length + ", cnt:" + this.cnt + ", dist:" + dist + ", r1eported" + reported + ", parent:" + parents
              + " contribute:" + contr + " fluid:" + fluid + " between:" + between + ", edge:" + edgeSet;
    }
  }

}


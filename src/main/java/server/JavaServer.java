package server;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import search.MessagePackage;
import search.Operation;
import search.RemovePakcage;
import search.Search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class JavaServer {
  public static String PATH = "/Users/sycheng/Documents/thrift-0.11.0/tutorial/test/input/";

  public static String OUTPUT_PATH = "";

  public static SearchHandler handler;

  public static Search.Processor processor;

  public static int round = 1;

  public static int id;

  public static int portNumber = 10000;

  public static List<Integer> nei = new ArrayList<>();

  private static BlockingQueue<MessagePackage>  queue = new LinkedBlockingDeque<>(1000);
  private static BlockingQueue<RemovePakcage>  rmQueue = new LinkedBlockingDeque<>(1000);

  public static void main(String[] args) {
    try {
      if(args.length < 1) {
        System.err.println("Type id as cmd argument.");
        return;
      }

      id = Integer.parseInt(args[0]);
      int sleep = 5000;
      if (args.length >= 2) {
        sleep = Integer.parseInt(args[1]);
      }
      if (args.length >= 3) {
        PATH = args[2];
      }
      if (args.length >= 4) {
        round = Integer.parseInt(args[3]);
      }

      OUTPUT_PATH = PATH + "/output/" + round;

      handler = new SearchHandler(id, nei, queue, rmQueue);
      processor = new Search.Processor(handler);
      getNeighbors(nei);

      Runnable simple = () -> simple(processor);
      Runnable send = () -> {
        try {
          sendWorker();
        } catch (TException | InterruptedException e) {
          e.printStackTrace();
          System.out.println(e.fillInStackTrace());
        }
      };
      Runnable deleteSend = () -> {
        try {
          deletionSendWorker();
        } catch (TException | InterruptedException e) {
          e.printStackTrace();
          System.out.println(e.fillInStackTrace());
        }
      };

      new Thread(simple).start();
      Thread.sleep(sleep);
        sendInitMsg();

      new Thread(send).start();
      new Thread(deleteSend).start();

    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  private static void sendInitMsg() throws InterruptedException {
//    if (id != 1) return;
    MessagePackage msg = new MessagePackage();
    msg.id = id;
    msg.cnt = 1;
    msg.len = 1;
    msg.fromId = id;
    msg.op = Operation.SEARCH;
    for (int n : nei) {
      msg.to = n;
      queue.put(new MessagePackage(msg));
    }
  }

  public static void sendWorker() throws TException, InterruptedException {

    while (true) {
      MessagePackage msg = queue.take();
      sendMessage(msg.to, msg);
    }
  }
  public static void deletionSendWorker() throws TException, InterruptedException {

    while (true) {
      RemovePakcage msg = rmQueue.take();
      sendMessage(msg.to, msg);
    }
  }

  public static void simple(Search.Processor processor) {
    try {
      TServerTransport serverTransport = new TServerSocket(portNumber + id);

      TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

      // Use this for a multithreaded server
      // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server..." + id + ", nei:" + nei);
      server.serve();

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getCause());
    }
  }


  private static void getNeighbors(List<Integer> nei) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(PATH + id));

    try{
      while (scanner.hasNext()) {
        nei.add(scanner.nextInt());
      }
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getCause());
    }
    finally {
      scanner.close();
    }
  }

  private static void sendMessage(int toId, MessagePackage msg) throws TException {
    msg.fromId = id;
    System.out.println("send message:" + msg + ", from["+id+"]");
    TTransport transport;
    transport = new TSocket("localhost", portNumber + toId);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);
    Search.Client client = new Search.Client(protocol);

    perform(client, msg);

    transport.close();
  }
  private static void sendMessage(int toId, RemovePakcage msg) throws TException {
    msg.id = id;
    System.out.println("send remove message:" + msg + ", from["+id+"]");
    TTransport transport;
    transport = new TSocket("localhost", portNumber + toId);
    transport.open();

    TProtocol protocol = new TBinaryProtocol(transport);
    Search.Client client = new Search.Client(protocol);

    performRemoving(client, msg);

    transport.close();
  }

  private static void perform(Search.Client client, MessagePackage msg) throws TException {
    client.ping();
    client.search(msg);
  }
  private static void performRemoving(Search.Client client, RemovePakcage msg) throws TException {
    client.ping();
    client.remove(msg);
  }
}

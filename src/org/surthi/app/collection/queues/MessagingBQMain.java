package org.surthi.app.collection.queues;

import java.util.concurrent.LinkedBlockingDeque;

public class MessagingBQMain {
  public static void main(String... args) {
    LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();

    Thread producer = new Thread(new Producer(queue));
    Thread consumer = new Thread(new Consumer(queue));
    producer.start();
    consumer.start();
  }
}


class Producer implements Runnable {
  private LinkedBlockingDeque<String> queue;

  public Producer(LinkedBlockingDeque<String> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        String msg = " Message " + i;
        queue.put(msg);
        System.out.println("Produced: " + msg);
        Thread.sleep(i * 1000);

      }
      queue.put("exit");
    } catch (InterruptedException ie) {
      System.out.println("Interrupted abnormally");
    }

  }
}


class Consumer implements Runnable {
  private LinkedBlockingDeque<String> queue;

  public Consumer(LinkedBlockingDeque<String> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      String msg = queue.take();
      while (!msg.equals("exit")) {
        // Thread.sleep(1000);
        msg = queue.take();
        System.out.println("Consumed " + msg);
      }
      System.out.println("Consumed " + msg);
    } catch (InterruptedException ie) {
      System.out.println("Interrupted abnormally");
    }
  }
}

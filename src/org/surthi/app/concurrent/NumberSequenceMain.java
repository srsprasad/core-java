package org.surthi.app.concurrent;

public class NumberSequenceMain {

  public static void main(String... args) {

    Cab c = new Cab();
    Thread even = new Thread(new EventNumberPrinter(c));
    Thread odd = new Thread(new OddNumberPrinter(c));
    c.setEmpId(1);
    even.start();
    odd.start();

    try {
      even.join();
      odd.join();
    } catch (InterruptedException exp) {

    }
  }
}


class EventNumberPrinter implements Runnable {

  private Cab cab;

  public EventNumberPrinter(Cab cab) {
    this.cab = cab;
  }

  @Override
  public void run() {
    int id;
    while ((id = cab.getEmpId()) <= 10) {
      if (id > 1 && (id % 2) == 0) {
        System.out.println("Event Thread: " + cab.getEmpId());
        cab.setEmpId(++id);
      } else {
        try {
          Thread.sleep(100);
        } catch (InterruptedException exp) {
          System.exit(-1);
        }
      }
    }
  }
}


class OddNumberPrinter implements Runnable {
  private Cab cab;

  public OddNumberPrinter(Cab cab) {
    this.cab = cab;
  }

  @Override
  public void run() {
    int id;
    while ((id = cab.getEmpId()) <= 10) {
      if (id == 1 || (id % 2) != 0) {
        System.out.println("Odd Thread: " + cab.getEmpId());
        cab.setEmpId(++id);
      } else {
        try {
          Thread.sleep(100);
        } catch (InterruptedException exp) {
          System.exit(-1);
        }
      }
    }
  }
}


class Cab {
  private int empId;

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }
}

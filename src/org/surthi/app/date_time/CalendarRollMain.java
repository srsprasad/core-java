package org.surthi.app.date_time;

import java.util.Calendar;

public class CalendarRollMain {
  public static void main(String... args) {
    Calendar c = Calendar.getInstance();
    System.out.println("Current Time: " + c.getTime());
    c.set(Calendar.DATE, -240);
    c.add(Calendar.DATE, -240);
    System.out.println("Before 30 DAYS time: " + c.getTime());
  }
}

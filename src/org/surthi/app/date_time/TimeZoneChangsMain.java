package org.surthi.app.date_time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneChangsMain {

  private static SimpleDateFormat dateFormat;

  public static void main(String... args) {
    SimpleDateFormat gmtFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
    gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    SimpleDateFormat testFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
    testFormat.setTimeZone(TimeZone.getTimeZone("CST"));
    System.out.println("Central Time of date: " + testFormat.format(new Date()));
    System.out.println("GMT Time of date: " + gmtFormat.format(new Date()));
  }
}

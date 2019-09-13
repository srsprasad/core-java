package org.surthi.app.date_time;

import java.time.*;
import java.util.Scanner;

public class ClockMain {

  public static void main(String... args) {
    ClockMain app = new ClockMain();
    Scanner sc = null;
    String input = null;
    do {
      sc = new Scanner(System.in);
      input = sc.next();
      Clock clock = app.getClock(input);
      if (clock != null) {
        OffsetDateTime localZoneDateTime = OffsetDateTime.now(clock);
        OffsetDateTime givenTime = OffsetDateTime.of(1980, 07, 07, 07, 30, 10, 20, ZoneOffset.UTC);
        System.out.println("ISO8601 standard data time: " + givenTime);
        System.out.println("To LocalDateTime: " + givenTime.toLocalDateTime());
        System.out.println("To LocalDate: " + givenTime.toLocalDate());
        System.out.println("To LocalTime: " + givenTime.toLocalTime());
        System.out.println("To OffsetTime: " + givenTime.toOffsetTime());
        System.out.println("To UTC: " + givenTime.atZoneSameInstant(Clock.systemUTC().getZone()));
        ZonedDateTime zDateTime = givenTime.atZoneSameInstant(Clock.systemUTC().getZone());
        System.out.println("UTC reverted to GIVEN Zone: "
            + ZonedDateTime.ofInstant(zDateTime.toInstant(), clock.getZone()));

        System.out.println("Input Zone: " + clock.getZone());
        System.out.println("UTC Zone: " + Clock.systemUTC().getZone());

      }
    } while (input != null && !input.equalsIgnoreCase("exit"));
  }

  public Clock getClock(String zoneShortName) {
    String zone = ZoneId.SHORT_IDS.get(zoneShortName);
    return (zone != null) ? Clock.system(ZoneId.of(zone)) : null;
  }
}

package org.surthi.app.generics;

import java.util.ArrayList;
import java.util.List;

public class PolymarphicGenaricsMain {
  public static void main(String... args) {
    System.out.println("Generics example 1");

    final List<Person> persons = new ArrayList<>();

    List<Driver> drivers = new ArrayList<>();
    List<Person> citizens = new ArrayList<>();
    addAll(drivers, persons);
    addAll(citizens, persons);
  }

  static void addAll(List<? extends Person> source, List<Person> datahub) {
    datahub.addAll(source);
  }
}


class Person {
  String firstName;
  String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}


class Driver extends Person {
  String vehcleType;

  public String getVehcleType() {
    return vehcleType;
  }

  public void setVehcleType(String vehcleType) {
    this.vehcleType = vehcleType;
  }
}

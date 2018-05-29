package org.surthi.app.concurrent.forkjoin;

import java.util.Date;

public class Member {
  private String name;
  private Date dateOfBirth;
  private Date registeredDate;

  public Member(String name, Date dateOfBirth, Date registeredDate) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.registeredDate = registeredDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  @Override
  public String toString() {
    return "Member{" + "name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", registeredDate="
        + registeredDate + '}';
  }
}

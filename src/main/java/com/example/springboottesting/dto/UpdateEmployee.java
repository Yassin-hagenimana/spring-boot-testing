package com.example.springboottesting.dto;

public class UpdateEmployee {
  private String names;
  private String salary;
  private  String title;
  private String location;

  public UpdateEmployee(String names, String salary, String title, String location) {
    this.names = names;
    this.salary = salary;
    this.title = title;
    this.location = location;
  }


  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}

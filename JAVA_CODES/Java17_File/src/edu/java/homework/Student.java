package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable {
  private String name;
  private int eng;
  private int math;

  public Student() {}

  public Student(String name, int eng, int math) {
    super();
    this.name = name;
    this.eng = eng;
    this.math = math;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public void displayInfo() {
    System.out.println("Student [name=" + name + ", eng=" + eng + ", math=" + math + "]");
  }
}

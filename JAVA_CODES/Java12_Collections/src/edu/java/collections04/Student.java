package edu.java.collections04;

public class Student {
  private String name;
  private Score score;

  public Student() {}

  public Student(String name, Score score) {
    this.name = name;
    this.score = score;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(Score score) {
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public Score getScore() {
    return score;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", score=" + score + "]";
  }
}

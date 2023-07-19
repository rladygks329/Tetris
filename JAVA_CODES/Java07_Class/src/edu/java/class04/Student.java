package edu.java.class04;

public class Student {
  int stuNo;
  String name;
  Scores scores;

  public Student() {
    this.stuNo = 0;
    this.name = "";
    this.scores = new Scores(0, 0, 0);
  }

  public Student(int stuNo, String name, Scores scores) {
    this.stuNo = stuNo;
    this.name = name;
    this.scores = scores;
  }

  @Override
  public String toString() {
    return "학생의 이름 : " + name + "\n학번 : " + stuNo + "\n" + scores.toString();
  }
}

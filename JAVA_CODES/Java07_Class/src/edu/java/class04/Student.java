package edu.java.class04;

public class Student {
  // 멤버 변수(필드, 프로퍼티)
  int stuNo; // 학생 번호
  String name; // 학생 이름
  Scores scores; // 학생 점수

  public Student() {}

  public Student(int stuNo, String name, Scores scores) {
    this.stuNo = stuNo;
    this.name = name;
    this.scores = scores;
  }

  @Override
  public String toString() {
    return "학생의 이름 : " + name + "\n학번 : " + stuNo + "\n" + scores.toString();
  }

  public void printStudentInfo() {
    System.out.println("--- 학생 정보 ---");
    System.out.println("번호 : " + stuNo);
    System.out.println("학생의 이름 : " + name);
    scores.printScores();
    System.out.println("총점 : " + scores.calcTotal());
    System.out.println("평균 : " + scores.calcAverage());
  } // end printStudentInfo

}// end student

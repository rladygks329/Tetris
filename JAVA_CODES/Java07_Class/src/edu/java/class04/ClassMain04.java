package edu.java.class04;

public class ClassMain04 {

  public static void main(String[] args) {
    Scores s = new Scores(10, 20, 30);
    Student james = new Student(10, "james", s);
    System.out.println(james.toString());
  }

}

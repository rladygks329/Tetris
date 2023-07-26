package edu.java.homework;

public class 김요한04_2 {
  public static void main(String[] args) {
    String str = "모든 프로그램은 Java 언어로 개발할 수 있다.";

    int index = str.indexOf("Java");
    if (index == -1) {
      System.out.println("자바 문자열이 포함되어 있지 않습니다.");
    } else {
      System.out.println("자바 문자열이 포함되어 있습니다.");
      str = str.replace("Java", "자바");
      System.out.println("-> " + str);
    }
  }
}

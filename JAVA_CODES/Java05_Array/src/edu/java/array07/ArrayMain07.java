package edu.java.array07;

public class ArrayMain07 {

  public static void main(String[] args) {
    System.out.println("배열 연습3");
    String test = "문자열입니다.";

    System.out.println(test);
    System.out.println("문자열의 길이 : " + test.length());

    for (int i = 0; i < test.length(); i++) {
      System.out.print(test.charAt(i) + " ");
    }

    // 문자열 배열 선언
    String[] subjects = {"국어", "영어", "수학", "프로그래밍"};

    // "영어"의 문자열 길이를 출력
    for (String subject : subjects) {
      System.out.println("과목명 : " + subject);
      System.out.println("무자열 길이 : " + subject.length());
    }

  } // end main()

} // end ArrayMain07

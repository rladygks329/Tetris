package edu.java.exception04;

public class ExceptionMain04 {

  public static void main(String[] args) {
    // Exception : 예외 처리를 위한 클래스
    // |_ArithmeticException
    // |_NullPointerException
    // |_...

    System.out.println("예외 메시지 출력");
    try {
      System.out.println("try 내부");
      String name = null;
      System.out.println("문자열 길이 : " + name.length());
    } catch (NullPointerException e) {
      System.out.println("예외 메시지: " + e.toString());
    }
  } // end Main()

} // end ExceptionMain04

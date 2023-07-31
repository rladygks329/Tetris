package edu.java.exception06;

public class ExceptionMain06 {

  public static void main(String[] args) {
    // g하나의 try 구문에서 여러개의 catch를 사용하는 방법2: Java 7 버전 부터
    // try {
    // }catch (Ex1 | ex2| ex3|e) {
    // }catch(Exception e) {...}
    try {
      int x = 12345;
      int y = 0;
      int result = x / y;
      System.out.println("result = " + result);

      int[] array = new int[10];
      array[11] = 10;
      System.out.println("array[11] = " + array[11]);

      String name = null;
      System.out.println("문자열 길이 : " + name.length());
    } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
      System.out.println("산술 연산 예외 : " + e.toString());
    } catch (Exception e) {
      System.out.println("예외 메시지: " + e.toString());
    }

  } // end main()

} // end ExceptionMain06

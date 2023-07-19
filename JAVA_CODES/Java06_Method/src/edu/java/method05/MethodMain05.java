package edu.java.method05;

// 메소드 overloading
// 1. 메게 변수의 개수나 타입이 다른 경우 같은 이름으로 정의 할 수 있음
// 단, 메소드의 리턴타입만 다른 경우는 같은 이름으로 메소드를 정의할 수 없음

public class MethodMain05 {

  public static void main(String[] args) {

    System.out.println();
    System.out.println("문자열");
    System.out.println(1);
    System.out.println(1.0);
    System.out.println(true);

    sayHello();
    sayHello("james");
  } // end Main()

  public static void sayHello() {
    System.out.println("안녕하세요");
  }

  public static void sayHello(String name) {
    System.out.println(name + "님안녕하세요");
  }

} // end MethodMain03

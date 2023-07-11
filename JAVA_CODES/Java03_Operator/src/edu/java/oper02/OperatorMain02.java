package edu.java.oper02;


public class OperatorMain02 {

  public static void main(String[] args) {

    System.out.println("복합 대입 연산 ");
    // +=, -=, /=, *=, %=

    int age = 16;
    age = age + 1; // 현재 age 값에 1을 더하여, age에 저장
    System.out.println("age = " + age);

    age += 1;
    System.out.println("age = " + age);

    int x = 123;
    x -= 10; // x = x - 10
    System.out.println("x = " + x);

  } // end main

} // end OperationMain

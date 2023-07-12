package edu.java.if06;

import java.util.Scanner;

public class IfMain06 {

  public static void main(String[] args) {
    System.out.println("if 중첩문 연습");

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    sc.close();

    if (num % 2 == 0) {
      System.out.println("짝수");
      if (num % 4 == 0) {
        System.out.println("4의 배수");
      } else {
        System.out.println("4의 배수가 아닌 짝수");
      }
    } else {
      System.out.println("홀수");
    }
  } // end Main()

} // end IfMain06

package edu.java.if02;

import java.util.Scanner;

public class IfMain02 {

  public static void main(String[] args) {
    System.out.println("if-else");
    // if(조건) {본문A}
    // else {본문B}
    // - 조건이 참이면, 본문A가 실행되고, 거짓이면 본문B가 실행.

    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();

    if (x > 0) {
      System.out.printf("%d는 양수", x);
    } else { // x <= 0
      System.out.printf("%d는 0 보다 크지 않습니다.", x);
    }

  } // end main

} // end IfMain02

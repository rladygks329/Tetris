package edu.java.if04;

import java.util.Scanner;

public class ifMain04 {

  public static void main(String[] args) {
    System.out.println("if - else if - else 연습");

    // 점수에 따라 성적 나누기
    Scanner sc = new Scanner(System.in);
    int score = sc.nextInt();

    System.out.println("성적을 입력하세요");
    if (score >= 90) {
      System.out.println("A");
    } else if (score >= 80) {
      System.out.println("B");
    } else if (score >= 70) {
      System.out.println("C");
    } else {
      System.out.println("F");
    }

    sc.close();

  } // end main()

} // end ifMain04

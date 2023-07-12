package edu.java.if05;

import java.util.Scanner;

public class IfMain05 {

  public static void main(String[] args) {
    System.out.println("문자를 알려주세요");

    // 대소문자 판별
    Scanner sc = new Scanner(System.in);
    char c = sc.next().charAt(0);

    if ('A' <= c && c <= 'Z') {
      System.out.println("영대문자");
    } else if ('a' <= c && c <= 'z') {
      System.out.println("영소문자");
    } else {
      System.out.println("모르겠습니다.");
    }

    sc.close();

  } // end main()

} // end IfMain05

package edu.java.variable10;

import java.util.Scanner;

public class ScannerMain03 {
  public static void main(String[] args) {

    System.out.println("문자 하나 입력");
    Scanner sc = new Scanner(System.in);

    char ch = sc.next().charAt(0); // 문자 하나 입력 후 저장

    // String str = sc.next();
    // char ch = str.charAt(0);

    System.out.println("ch = " + ch);

    sc.close();

  }
}

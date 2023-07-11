package edu.java.variable09;

import java.util.Scanner;

public class ScannerMain02 {
  public static void main(String[] args) {

    System.out.println("문자열 입력");
    System.out.println("이름 입력 : ");

    Scanner sc = new Scanner(System.in);
    String name = sc.next();

    System.out.println("name = " + name);

    sc.close();

  } // end main

} // end ScannerMain02

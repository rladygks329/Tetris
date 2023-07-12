package edu.java.while02;

import java.util.Scanner;

public class WhileMain02 {

  public static void main(String[] args) {
    System.out.println("while 구구단 연습");

    Scanner sc = new Scanner(System.in);

    int i = sc.nextInt();
    int j = 1;
    System.out.println(i + "단");

    while (j <= 9) {
      System.out.println(i + " X " + j + " = " + i * j);
      j++;
    }

    i = 2;
    j = 1;

    while (i <= 9) {
      j = 1;
      while (j <= 9) {
        System.out.println(i + " X " + j + " = " + i * j);
        j++;
      }
      System.out.println();
      i++;
    }

    for (int a = 4; a <= 9; a++) {
      for (int b = 2; b <= 7; b++) {
        System.out.println(a + " x " + b + " = " + a * b);
      }
      System.out.println();
    }

    System.out.println("정사각형의 크기를 넣어주세요");
    int n = sc.nextInt();
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        System.out.print("*");
      }
      System.out.println();
    }

    System.out.println("삼각형형의 크기를 넣어주세요");
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        if (x + y < n) {
          System.out.print("*");
        }
      }
      System.out.println();
    }


    sc.close();
  } // end main()

} // end WhileMain01

package edu.java.codeup;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int count = -a;
    String box = "";

    for (int i = 1; i < b; i++) {
      box += " ";
    }

    for (int i = 0; i < a; i++) {
      for (int j = 0; j < a; j++) {
        count++;
        if (i == 0 || i == a - 1 || j == 0 || j == a - 1) {
          System.out.print("*");
        } else {
          int remain = count % b;

          if (0 <= remain && remain < b - 1) {
            // b-1개의 빈칸을 채우되 j + k가 b-1인경우
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
      }
      System.out.println();
    }
  }
}

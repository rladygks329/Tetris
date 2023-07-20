package edu.java.codeup;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = 0; i < a; i++) {
      for (int j = 0; j < a; j++) {
        if (i == 0 || i == a - 1 || j == 0 || j == a - 1) {
          System.out.print("*");
        } else if ((i + j - 1) % b == 0) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    sc.close();
  }
}

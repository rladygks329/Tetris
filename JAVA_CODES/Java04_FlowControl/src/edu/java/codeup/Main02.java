package edu.java.codeup;

import java.util.Scanner;

public class Main02 {

  public static void main(String args[]) {
    // code up 1358
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int middle = n / 2;
    for (int i = 0; i <= middle; i++) {
      for (int j = 0; j <= middle + i; j++) {
        if (i + j < middle) {
          System.out.print(" ");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }
}

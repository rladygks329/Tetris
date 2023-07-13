package edu.java.codeup;

import java.util.Scanner;

public class Main04 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] array = new int[n];

    for (int i = 0; i < n - 1; i++) {
      int j = sc.nextInt();
      array[j - 1] = 1;
    }

    for (int i = 0; i < n; i++) {
      if (array[i] == 0) {
        System.out.println(i + 1);
      }
    }
  }

}

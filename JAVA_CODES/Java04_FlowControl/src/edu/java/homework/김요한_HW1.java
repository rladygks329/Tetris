package edu.java.homework;

import java.util.Scanner;

public class 김요한_HW1 {

  public static void main(String[] args) {

    // a to z
    for (char i = 'A'; i <= 'Z'; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    // 주사위합 5이면 멈추기
    int x = 0;
    int y = 0;
    int count = 0;

    while (x + y != 5) {
      x = (int) (Math.random() * 6) + 1;
      y = (int) (Math.random() * 6) + 1;
      System.out.println("x = " + x + " y = " + y);
      count++;
    }
    System.out.println(count + "번 만에 주사위의 합이 5가 되었습니다.");

    // 1- n까지 형태로 더하는데 짝수는 음수다. 100이상이 되었을때, n, sum출력
    // 1 -1 2 -1 3 .... 2k -> -1, 2k+1 = k+1
    System.out.println("n을 입력해주세요");
    Scanner sc = new Scanner(System.in);
    int i = 1;
    int sum = 0;

    while (sum < 100) {
      sum += ((i % 2 == 0)) ? -i : i;
      i++;
    }
    System.out.println("n = " + (i - 1) + " sum = " + sum);

    // 평행사변형 만들기
    System.out.println("n을 입력해주세요");
    int n = sc.nextInt();

    // top
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < j + 1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // bottom
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < n; k++) {
        System.out.print((k < j) ? " " : "*");
      }
      System.out.println();
    }

    sc.close();

  } // end main()

} // end 김요한_HW1

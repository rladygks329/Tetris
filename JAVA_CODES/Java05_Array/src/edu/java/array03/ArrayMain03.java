package edu.java.array03;

import java.util.Scanner;

public class ArrayMain03 {

  public static void main(String[] args) {
    System.out.println("배열 연습");

    Scanner sc = new Scanner(System.in);
    // ctrl + shift + o : 자동 import 단축키

    // n명의 학생 점수를 입력받아
    // 총합, 평균, 최대값, 최소값 출력

    int n = sc.nextInt();
    int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    int[] scores = new int[n];

    // in, check
    for (int i = 0; i < n; i++) {
      System.out.println("scores[" + i + "] 점수입력>");
      scores[i] = sc.nextInt();
      sum += scores[i];
      max = (scores[i] > max) ? scores[i] : max;
      min = (scores[i] < min) ? scores[i] : min;
    }

    // out
    for (int i = 0; i < n; i++) {
      System.out.println("scores[" + i + "] = " + scores[i]);
    }

    System.out.printf("avg: %.3f\n", sum / (double) n);
    System.out.println("sum : " + sum);
    System.out.println("min : " + min);
    System.out.println("max : " + max);

    sc.close();
  } // end main()

} // end ArrayMain03

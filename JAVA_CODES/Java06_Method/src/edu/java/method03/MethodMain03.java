package edu.java.method03;

import java.util.Scanner;

public class MethodMain03 {
  public static int getSum(int a, int b, int c) {
    return a + b + c;
  }

  public static double getAvg(int sum) {
    return sum / 3.0;
  }

  public static char getGrade(double avg) {
    if (90 <= avg && avg <= 100) {
      return 'A';
    }
    if (avg >= 80) {
      return 'B';
    }
    if (avg >= 70) {
      return 'C';
    }
    return 'F';
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int kor = sc.nextInt();
    int eng = sc.nextInt();
    int math = sc.nextInt();
    // 총점 출력
    int sum = getSum(kor, eng, math);
    System.out.println("총합 : " + sum);

    // 평균 출력
    double avg = getAvg(sum);;
    System.out.println("평균 : " + avg);

    // 등급 출력
    char grade = getGrade(avg);
    System.out.println("등급 : " + grade);
    sc.close();
  } // end Main()

} // end MethodMain03

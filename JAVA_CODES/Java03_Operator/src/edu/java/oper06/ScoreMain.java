package edu.java.oper06;

import java.util.Scanner;

public class ScoreMain {

  public static void main(String[] args) {
    System.out.println("총점 및 평균 계산 프로그램");

    Scanner sc = new Scanner(System.in);
    int kor, eng, math;

    System.out.println("국어 성적을 입력하세요");
    kor = sc.nextInt();

    System.out.println("영어 성적을 입력하세요");
    eng = sc.nextInt();

    System.out.println("수학 성적을 입력하세요");
    math = sc.nextInt();

    System.out.println("국어: " + kor);
    System.out.println("영어: " + eng);
    System.out.println("수학: " + math);

    int total = kor + eng + math;
    System.out.println("총점은 : " + total);

    double avg = total / 3.0;
    System.out.printf("평균은 : %.3f", avg);

    sc.close();
  } // end main

} // end ScoreMain

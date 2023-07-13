package edu.java.loop03;

import java.util.Scanner;

public class Banking {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    boolean runnable = true;
    int money = 0;

    System.out.println("JAVA 은행");
    while (runnable) {
      System.out.println("--------------------------------------");
      System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
      System.out.println("--------------------------------------");
      System.out.print("선택> ");

      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("예금액>");
          money += sc.nextInt();
          System.out.println("현재 잔고는 " + money + " 입니다");
          break;
        case 2:
          System.out.println("출금액");
          money -= sc.nextInt();
          System.out.println("현재 잔고는 " + money + " 입니다");
          break;
        case 3:
          System.out.println("현재 잔고는 " + money + " 입니다");
          break;
        case 4:
          System.out.println("JAVA 은행이 종료되었습니다.");
          runnable = false;
          break;
        default:
          System.out.println("1 ~ 4 사이의 값을 넣어주세요");
          break;
      }
    }
    sc.close();

  }// end main()

}// end Banking

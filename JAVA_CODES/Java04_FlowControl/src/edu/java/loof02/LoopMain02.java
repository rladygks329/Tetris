package edu.java.loof02;

import java.util.Scanner;

public class LoopMain02 {

  public static void main(String[] args) {

    // 무한 루프
    // while (true) {
    // System.out.println("자니");
    // }
    //
    // for (;;) {
    // System.out.println("밥먹었니");
    // }

    // 두 개의 주사위를 던져서 나온 값을 (x, y)와 같은 형식으로 출력
    // 두개의 주사위가 같은 숫자가 되면 종료
    Scanner sc = new Scanner(System.in);
    int x = 1;
    int y = 6;
    int count = 0;
    // 예시를 위해 무한 루프를 썼으나 x != y를 조건으로 주면 더 깔끔해짐
    while (true) {
      count++;
      x = (int) (Math.random() * 6) + 1;
      y = (int) (Math.random() * 6) + 1;
      System.out.println("x: " + x + " y: " + y);
      if (x == y) {
        System.out.println("같은 수가 " + count + "번 만에 나왔습니다.");

        break;
      }
    }

    sc.close();

  }

}

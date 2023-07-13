package edu.java.loof01;

public class LoopMain01 {

  public static void main(String[] args) {
    System.out.println("break");
    // break 키워드
    // 반복문 안에서 break를 만나면
    // 가장 가까운 반복문을 종료

    for (int i = 1; i <= 10; i++) {
      System.out.println(i);
      // i == 5인 경우 반복문 종료
      if (i == 5) {
        break;
      }
    }

    System.out.println("=====");
    for (int i = 2; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.println(i + " x " + j + " = " + i * j);
      }
      if (i == 5) {
        break;
      }
    }

    System.out.println("=====continue=====");
    for (int i = 1; i <= 10; i++) {
      // i == 5인 경우 스킵하기
      if (i == 5) {
        continue;
      }
      System.out.print(i + " ");
    }



  } // end Main()

} // end LoopMain01

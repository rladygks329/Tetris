package edu.java.for02;

public class ForMain02 {

  public static void main(String[] args) {
    // println 줄바꿈 o
    // print 줄바꿈 x

    // 0246810
    // 아래의 3개의 코드 블록은 모두 동일하나
    // 마지막 경우는 가독성을 더 신경썼고, 초기 두개의 코드는 성능이 조금 더 좋다

    for (int i = 0; i <= 10; i += 2) {
      System.out.print(i + " ");
    }

    System.out.println();
    for (int i = 0; i <= 5; i += 1) {
      System.out.print(2 * i + " ");
    }

    System.out.println();
    for (int i = 0; i <= 10; i++) {
      if (i % 2 == 0) {
        System.out.print(i + " ");
      }
    }

  } // end main()

} // end ForMain02

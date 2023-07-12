package edu.java.while01;

// while 문
// - for문과 같은 반복문
// - 선언 형태
// while(조건) {
// (본문)
// }
public class WhileMain01 {

  public static void main(String[] args) {
    System.out.println("while 반복문");

    // 0 ~ 10까지 출력
    int i = 0;
    while (i <= 10) {
      System.out.print(i++ + " ");
    }

    System.out.println();
    // 10 - 1까지
    i = 10;
    while (i > 0) {
      System.out.print(i-- + " ");
    }
  } // end main()

} // end WhileMain01

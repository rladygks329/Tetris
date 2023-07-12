package edu.java.for01;

// for 반복문
// - 반벅수행을 하기 위한 키워드
// - for(초기식; 조건식; 증감식;){
// (본문)
// }
// - 초기값을 증감시켜서 false가 될 때 까지 본문을 반복
// - 실행 순서
// 1) 초기식. 2)조건식. 3)본문. 4)증감식.

public class ForMain01 {

  public static void main(String[] args) {

    // 1 -10
    for (int i = 1; i <= 10; i++) {
      System.out.print(i + " ");
    }

    // 1, 3, 5, 7, 9
    System.out.println();
    for (int i = 1; i <= 9; i += 2) {
      if (i % 2 == 1) {
        System.out.print(i + " ");
      }
    }

    // 15, 14 .... 1
    System.out.println();
    for (int i = 15; i > 0; i -= 1) {
      System.out.print(i + " ");
    }

  } // end main()

} // end ForMain01

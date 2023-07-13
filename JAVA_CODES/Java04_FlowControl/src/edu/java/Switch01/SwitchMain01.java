package edu.java.Switch01;

import java.util.Scanner;

// switch - case 문
// - if 문과 비슷하지만 비교값을 정형화한 형식
// - 변수와 일치하는 값에 따라 해당 case 문이 실행됨
// - switch(변수) {
// case 값1:
// break;
// }
public class SwitchMain01 {

  public static void main(String[] args) {
    // ctrl shift f : code auto formatting
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();

    System.out.println("if - else 문");
    if (a == 1) {
      System.out.println("1번 선택");
    } else if (a == 2) {
      System.out.println("2번 선택");
    } else if (a == 3) {
      System.out.println("3번 선택");
    } else {
      System.out.println("그 외 선택");
    }

    System.out.println("switch 문");
    switch (a) {
      case 1:
        System.out.println("1 번선택");
        break;
      case 2:
        System.out.println("2 번선택");
        break;
      case 3:
        System.out.println("3 번선택");
        break;
      case 4:
        System.out.println("4 번선택");
        break;
      default:
        System.out.println("1 번선택");
        break;
    }

  } // end main()

} // end SwitchMain01

package edu.java.exception08;

import java.util.Scanner;

public class ExceptionMain08 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // try - catch를 이용하여
    // 숫자가 아닌 값을 입력하면
    // "숫자가 아닙니다." 라고 출력하고
    // 다시 메뉴 선택이 가능하도록 만들어보세요.
    // 숫자를 입력하면 종료됩니다.
    while (true) {
      System.out.println("메뉴 선택");
      try {
        int choice = Integer.parseInt(sc.next());
        System.out.println("choice : " + choice);
        break;
      } catch (Exception e) {
        System.out.println("숫자가 아닙니다.");
      }
    }
  } // end main()

} // end ExceptionMain08

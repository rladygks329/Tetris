package edu.java.array11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScoreBoard {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int[] students;
    int stuNo = 0;
    int input = 0;

    /*
     * 1. 첫 번째 글자는 문자이거나, '$', '_' 이어야하고 숫자로 시작할 수 없다. (필수) 2. 영어 대소문자가 구분된다. (필수) 3. 첫 문자는 영어 소문자로
     * 시작하되, 다른 단어가 붙을 경우 첫 문자를 대문자로 한다. (관례) 4. 문자 수 (길이)의 제한은 없다. \ 5. 자바 예약어는 사용할 수 없다.
     */
    System.out.println("< 학생 점수 관리 프로그램 >");
    System.out.println("학생 수를 입력하세요 >");
    stuNo = sc.nextInt();
    System.out.println("입력된 학생수 : " + stuNo);

    students = new int[stuNo];

    while (input != 4) {
      System.out.println("--------------------------------------------------");
      System.out.println("1. 점수입력 | 2. 점수 리스트 | 3.분석 | 4. 종료");
      System.out.println("--------------------------------------------------");
      System.out.println("선택>");

      input = sc.nextInt();
      switch (input) {
        case 1:
          for (int i = 0; i < stuNo; i++) {
            System.out.println(i + 1 + "번 학생의 점수를 입력하세요>");
            students[i] = sc.nextInt();
          }
          break;
        case 2:
          for (int i = 0; i < stuNo; i++) {
            System.out.println(i + 1 + "번 학생의 점수: " + students[i]);
          }
          break;
        case 3:
          Integer[] rank = Arrays.stream(students).boxed().toArray(Integer[]::new);
          Arrays.sort(rank, Collections.reverseOrder());

          for (int i = 0; i < stuNo; i++) {
            System.out.println(i + 1 + "등: " + rank[i]);
          }
          break;
        case 4:
          System.out.println("프로그램을 종료합니다.");
          break;
        default:
          System.out.println("올바른 값을 입력해주세요");
          break;
      }
    }
    sc.close();
  } // end main()

} // end scoreBoard

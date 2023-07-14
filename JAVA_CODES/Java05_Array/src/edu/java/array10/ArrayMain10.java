package edu.java.array10;

public class ArrayMain10 {

  public static void main(String[] args) {
    System.out.println("배열 연습4");
    int[] integer = {11, 10, 8, 6};

    // 인덱스가 짝수인 정수 출력
    for (int i = 0; i < integer.length; i++) {
      if (i % 2 == 0) {
        System.out.println(integer[i]);
      }
    }

    // 값이 짝수인 정수 출력
    for (int i = 0; i < integer.length; i++) {
      if (integer[i] % 2 == 0) {
        System.out.println(integer[i]);
      }
    }

    String[] str = {"사과", "배", "바나나", "당근"};
    // 문자열 배열 원소 중에 "배" 라는 글자가 있으면
    // "배를 찾았습니다"라고 출력
    for (String s : str) {
      if (s == "배") {
        System.out.println(s + "을(를) 찾았습니다!");
      }
    }
  } // end main()

} // end ArrayMain09

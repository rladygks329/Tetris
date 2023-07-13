package edu.java.array02;

public class ArrayMain02 {

  public static void main(String[] args) {
    System.out.println("배열의 선언, 초기화, 출력");

    int[] array = new int[10];
    System.out.println(array.length);

    // 배열의 인덱스 : 0 ~ (length - 1)
    // for문을 사용하여 배열에 1 ~ 10까지의 값을 저장
    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
    }

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

    // 내림차순 출력
    for (int i = array.length - 1; i >= 0; i--) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

    // for 문을 사용하여 배열의 모든 값(원소)들을 더하기
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    System.out.println("sum = " + sum);

  } // end main()

} // end ArrayMain02

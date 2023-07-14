package edu.java.array06;

public class ArrayMain06 {

  public static void main(String[] args) {
    System.out.println("배열 연습");

    boolean[] arr1 = {true, false, true, false};

    for (boolean b : arr1) {
      System.out.println(b);
    }

    System.out.println("==========");
    boolean[] arr2 = new boolean[4];
    // 배열의 인덱스가 짝수일 때는 true, 홀수일 때는 false를 저장
    for (int i = 0; i < arr2.length; i++) {
      arr2[i] = (i % 2) == 0;
    }

  } // end main()

} // end ArrayMain06

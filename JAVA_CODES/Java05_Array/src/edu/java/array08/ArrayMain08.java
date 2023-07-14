package edu.java.array08;

public class ArrayMain08 {

  public static void main(String[] args) {
    System.out.println("2차원 배열");

    // 2차원 배열: 1차원 배열을 원소로 갖는 배열
    int[] korean = {10, 20, 30}; // 1차원 배열
    int[] english = {40, 50, 60}; // 1차원 배열

    int[][] scores = {korean, english};

    System.out.println(scores[1][1]);
    System.out.println(scores[0][2]);
    System.out.println("i의 길이(개수): " + scores.length);

    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        System.out.print(scores[i][j] + " ");
      }
      System.out.println();
    }

    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        System.out.print(scores[i][scores[i].length - j - 1] + " ");
      }
      System.out.println();
    }

    int[][] a = new int[3][4]; // 3 * 4 배열 생성
    // 배열이 생성되면서 특정 주소값을 갖는다.
    // 주소값은 컴퓨터의 메모리에 저장되는 위치를 의미한다.

    System.out.println(a);

  } // end main()

} // end ArrayMain08

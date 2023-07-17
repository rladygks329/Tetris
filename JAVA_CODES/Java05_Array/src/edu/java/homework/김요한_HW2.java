package edu.java.homework;

public class 김요한_HW2 {

  public static void main(String[] args) {

    // min, sum, avg
    int[] arr = {6, 8, 4, 2, 5};
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int a : arr) {
      max = (a > max) ? a : max;
      sum += a;
    }

    System.out.println("최대값은 " + max + " 입니다");
    System.out.println("전체합은 " + sum + " 입니다");
    System.out.println("전체 평균은 " + sum / (arr.length * 1.0) + " 입니다");

    // fibonachi
    int a = 1;
    int b = 1;

    for (int i = 1; i <= 20; i++) {
      System.out.println(i + "번째 피보나치의 수는 " + a + "입니다");

      int tmp = a + b;
      a = b;
      b = tmp;
    }

    int[][] array = {{95, 86}, {44, 22, 96}, {78, 83, 93, 87, 88}};
    int len = 0;
    sum = 0;

    for (int[] nums : array) {
      len += nums.length;
      for (int num : nums) {
        sum += num;
      }
    }

    System.out.println("전체 평균은 " + sum / (len * 1.0) + " 입니다");

  } // end main()

} // end HW_2

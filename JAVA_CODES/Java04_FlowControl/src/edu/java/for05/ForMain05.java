package edu.java.for05;

public class ForMain05 {

  public static void main(String[] args) {
    System.out.println("for문 연습");
    int sum = 0;

    for (int i = 1; i <= 10; i++) {
      sum += i;
    }
    System.out.println(sum);

    sum = 0;
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0) {
        sum += i;
      }
    }
    System.out.println(sum);
  } // end main()

} // end ForMain04

package edu.java.for03;

public class ForMain03 {

  public static void main(String[] args) {

    for (int i = 1; i <= 100; i++) {
      if (i % 10 == 0) {
        System.out.print(i + " ");
      }
    }
    System.out.println();

    for (int i = 0; i <= 100; i++) {
      System.out.print(i + " ");
      if (i % 10 == 0) {
        System.out.println();
      }
    }
  } // end main()

} // end ForMain03

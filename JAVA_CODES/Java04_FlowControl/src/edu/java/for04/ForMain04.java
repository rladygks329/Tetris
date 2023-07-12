package edu.java.for04;

public class ForMain04 {

  public static void main(String[] args) {

    for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) {
        System.out.println(i + " : 짝수입니다.");
      } else {
        System.out.println(i + " : 홀수입니다.");
      }
    }

    for (int i = 1; i <= 10; i++) {
      System.out.print(i + "꼬마 ");
      if (i % 3 == 0) {
        System.out.println("인디언");
      } else if (i % 10 == 0) {
        System.out.println("인디언 보이~");
      }
    }
  } // end main()

} // end ForMain04

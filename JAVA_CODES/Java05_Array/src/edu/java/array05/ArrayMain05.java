package edu.java.array05;

public class ArrayMain05 {

  public static void main(String[] args) {
    System.out.println("배열 연습 1");

    // 'a' ~ 'z'까지 저장 및 출력
    char[] alphabet = new char['z' - 'a' + 1];

    for (char ch = 'a'; ch <= 'z'; ch++) {
      alphabet[ch - 'a'] = ch;
    }

    for (char alpha : alphabet) {
      System.out.print(alpha + " ");
    }
  } // end main()

} // end ArrayMain05

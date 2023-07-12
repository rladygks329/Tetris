package edu.java.programmers;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    // 대소문자 바꿔서 출력하기
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    sc.close();

    int index;
    //// xor 중복 제거 풀이
    // char[] a1 = a.toCharArray();
    // char[] s1 = a.toUpperCase().toCharArray();
    // char[] s2 = a.toLowerCase().toCharArray();
    //
    // for(int i=0; i< a.length();i++) {
    // System.out.print((char) (a1[i]^s1[i]^s2[i]));
    // }

    for (char c : a.toCharArray()) {
      if ('a' <= c && c <= 'z') {
        index = c - 'a';
        System.out.print((char) (index + 'A'));
      } else {
        index = c - 'A';
        System.out.print((char) (index + 'a'));
      }
    }
  }
}

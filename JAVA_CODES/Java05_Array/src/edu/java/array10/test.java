package edu.java.array10;

import java.util.Arrays;

public class test {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    int b = Arrays.stream(a).sum();

    long c = 10000000000l;
    System.out.println(c % 10);
    System.out.println((int) c % 10);

    int d = 1234;
    String e = d + "";
    System.out.println(d + "x");

  }
}

package edu.java.oper04;

public class OperatorMain04 {

  public static void main(String[] args) {
    System.out.println("비교 연산자");
    System.out.println(10 > 20); // 10이 20보다 큰가?
    System.out.println(10 < 20); // 10이 20보다 작은가?
    System.out.println(10 == 20); // 10이 20과 같나?
    System.out.println(10 != 20); // 10이 20과 같지않나?
    System.out.println(10 <= 20); // 10이 20보다 작거나 같나?
    System.out.println(10 >= 20); // 10이 20보다 크거나 같나?

    System.out.println("논리연산자");
    boolean A = true;
    boolean B = false;
    System.out.println(A && B); // 곱연산자 (and)
    System.out.println(A || B); // 합연산자 (or)
    System.out.println(!B); // 부정연산자(not)

    int age = 35;
    String sex = "male";

    // 나이가 30이상이고, 성별이 "남"인 경우
    System.out.println((age >= 30) && (sex == "male"));
    System.out.println(age > 0 && age < 100);
    System.out.println(10 > 0 || 10 < 100); // or의 경우 앞에 것 먼저 계산되기 때문에
                                            // true || (code)인 경우 의미없는 코드가된다.

    System.out.println(10 <= 0 || 10 <= 100);
    System.out.println(!(111 < 100));


  } // end main

} // end OperatorMain

package edu.java.oper03;

// 증감 연산자
// - 변수의 값을 1증가 똔느 감소할 때 사용하는 연산자
// - 변수의 앞(prefix)과 뒤(suffix)에 사용
// - ++, --
public class OperatorMain03 {
  public static void main(String[] args) {

    System.out.println("증감 연산자 (++, --)");

    int num1 = 100;
    num1++;
    // num1 += 1
    // num = num + 1
    System.out.println("num1 = " + num1);

    int num2 = 100;
    ++num2;
    System.out.println("num2 = " + num2);

    int num3 = 100;
    int result = ++num3 + 5; // num3 = 101이되고, +5를 실행
    System.out.println("num3 = " + num3);
    System.out.println("result = " + result);

    int num4 = 100;
    result = num4++ + 5;
    System.out.println("num4 = " + num4); // +5를 실행 후 num4가 101이 된다.
    System.out.println("result = " + result);

    // 증감연산자는 변수 앞 또는 변수 뒤에 사용할 수 있음
    // 증감연산자가 단독으로 사용되는 경우는 앞과 뒤가 모두 동일한 결과
    // x++, ++x는 동일한 효과(단독으로 사용할 경우)
    // 증감 연산자가 다른 연산자와 함계 사용되는 경우는
    // 접두사(prefix)로 사용되는 경우는 다른 연산자보다 먼저 계산되고,
    // 접미사(suffix)로 사용되는 경우는 다른 연산자보다 나중에 계산됨

    int x = 10;
    result = x++ + 5 + ++x;
    // 퀴즈) result의 값과 그 이유 설명하기
    // 힌트) 연산 구조는 순차적으로 이루어진다.
    // 예) 1 + 2 + 3 => (1 + 2 = 3) + 3 = 6
    // 설명 -> 연산자 계산순서가 +, x++, ++x, =
    System.out.println(result);

  } // end main

} // end OperatorMain

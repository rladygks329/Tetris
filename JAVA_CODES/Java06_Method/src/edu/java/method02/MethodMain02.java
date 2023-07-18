package edu.java.method02;

public class MethodMain02 {

  public static int add(int x, int y) {
    return x + y;
  } // end add()

  public static int sub(int x, int y) {
    return (x > y) ? x - y : y - x;
  } // end add()

  public static double mul(double x, double y) {
    return x * y;
  } // end mul();

  public static double div(double x, double y) {
    return x / y;
  } // end div();

  // 기능 두개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
  public static void main(String[] args) {
    System.out.println("메소드 연습");

    int result = add(10, 20);
    System.out.println("result = " + result);

    result = sub(10, 20);
    System.out.println("result = " + result);

    double m = mul(1.5, 2.5);
    System.out.println("m = " + m);

    double d = div(3, 2);
    System.out.println("d = " + d);
  } // end Main()

} // end MethodMain02

package edu.java.variable07;

public class TypeCastringMain {
  public static void main(String[] args) {
    System.out.println("형 변환(Type Casting)");

    byte num1 = 123;
    int num2 = num1; // int > byte 이므로 자동 형 변환
    System.out.println("num2 = " + num2);

    int num3 = 123;
    byte num4 = (byte) num3; // byte < int 이므로 자동 형 변환 불가능
    // 지정된 사이즈로 강제로 형 변환 해야함.
    System.out.println("num4 = " + num4);

    // 주의) 만약 더 큰 수를 강제 형변환 할 시 오버플로우가 일어난다.
    int num5 = Byte.MAX_VALUE + 1;
    System.out.println("num5 = " + num5);

    byte num6 = (byte) num5;
    System.out.println("num6 = " + num6);

  } // end main()

}// end TypeCastingMain

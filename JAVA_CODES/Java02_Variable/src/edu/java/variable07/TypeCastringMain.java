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

    short num7 = 12345;
    // 12345는 리터럴(상수)이기 때문에 int 타입
    // 정수 리터럴 byte나 short에 저장할 때
    // 해당 타입이 저장할 수 있는 범위만 넘지 않으면
    // 자동형 변환을 해줌
    // int -> byte, int -> short

    // long 타입은 리터럴 자동 현 변환을 하지 않음
    long num8 = 100L;
    System.out.println("num8 = " + num8);

    double num9 = 100; // int -> double 자동 형 변환
    System.out.println("num9 = " + num9);

    // 실수 타입 리터럴을 int 로 전환
    int num10 = (int) 3.14;
    System.out.println("num10 = " + num10);


    char ch1 = 'A';
    System.out.println("ch1 = " + ch1); // 문자 자체 출력
    System.out.println("ch1 = " + (int) ch1); // 문자의 유니코드 값 출력

    char ch2 = (char) (ch1 + 1);
    System.out.println("ch2 = " + ch2);

  } // end main()

}// end TypeCastingMain

package edu.java.lambda02;

@FunctionalInterface
interface Test1 {
  public abstract void testPrint();
}


@FunctionalInterface
interface Test2 {
  public abstract void testPrint(int n);
}


public class LambdaMain02 {

  public static void main(String[] args) {
    System.out.println("- 익명 클래스, 람다 표현식 연습 -");
    // 람다(Lambda) 표현식
    // (매개변수1, 매개변수2, ...) -> {실행문; 리턴;}

    Test1 test1 = new Test1() {
      @Override
      public void testPrint() {
        System.out.println("익명 클래스");
      }
    };
    Test1 test2 = () -> System.out.println("람다 표현식");
    Test2 test3 = new Test2() {
      @Override
      public void testPrint(int n) {
        System.out.println("입력한 숫자는 : " + n);
      }
    };
    Test2 test4 = n -> System.out.println("입력한 숫자는 : " + n);

    test1.testPrint();
    test2.testPrint();
    test3.testPrint(100);
    test4.testPrint(200);



  } // end main()

}// end LambdaMain02

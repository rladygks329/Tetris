package edu.java.class03;

public class ClassMain03 {

  public static void main(String[] args) {
    MyCircle circle1 = new MyCircle();
    circle1.radius = 1.0;
    circle1.calcArea();
    System.out.println("반지름 :" + circle1.radius);
    System.out.println("면적 :" + circle1.calcArea());

    MyCircle circle2 = new MyCircle(10.0);
    circle2.calcArea();
    System.out.println("반지름 :" + circle2.radius);
    System.out.println("면적 :" + circle2.calcArea());


    MemberService memberService = new MemberService();
    boolean result = memberService.logIn("hong", "12345");

    if (result) {
      System.out.println("로그인 되었습니다.");
      memberService.logOut("hong");
    } else {
      System.out.println("id 또는 password가 올바르지 않습니다.");
    }

    Printer printer = new Printer();
    printer.println(10);
    printer.println(true);
    printer.println(5.7);
    printer.println("홍길동");

  } // end main()

} // end ClassMain03

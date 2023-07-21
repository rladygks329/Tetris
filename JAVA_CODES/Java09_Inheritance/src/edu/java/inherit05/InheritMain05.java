package edu.java.inherit05;

// * 모든 클래스의 부모 클래스는 Object 클래스이다.
public class InheritMain05 {

  public static void main(String[] args) {
    Person p1 = new Person("둘리");
    System.out.println(p1);
    System.out.println(p1.toString());
    // toString() : 객체가 가지고 있는 정보를 문자열로 출력
    // Object 클래스의 toString은 모든 클래스에서 사용 가능
    // p1과 p1.toString()은 같은 결과를 출력

    String str = new String("문자열");
    System.out.println(str);
    System.out.println(str.toString());

    // 즉석 퀴즈)
    // 1. point 클래스 생성
    // - 멤버 변수(double x double y)
    // 기본
    // 매개변수 생성자
    // toString 오버라이드하여 (x,y) 형의 문자열을 리턴하는 메소드 생성
    // 2. main 클래스의 main()메소드에서 Pont 변수 및 인스턴스를 생성하고
    // 아래와 같이 출력
    // 예시(1.0, 2.0)
    Point p = new Point(1.0, 2.0);
    System.out.println(p);
  } // end main()

} // end InheritMain05

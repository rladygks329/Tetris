package edu.java.class02;

// 클래스
// 상태(속성, 성질) - 멤버 변수 (field, property)
// 기능 - 메소드
// 생성자(constructor) - 멤버 변수들을 초기화
// - 클래스 이름과 동일하다.
// - 매개변수는 있을 수도 있고, 없을 수도 있다.
// - 자바 컴파일러가 기본 생성자를 자동으로 만들어줌.
// - 생성자를 하나라도 정의한 경우에는, 자동으로 생성자를 만들지않음.
public class MyRetangle {
  // 멤버 변수
  double width; // 사각형의 가로
  double height; // 사각형의 세로

  // 생성자
  public MyRetangle() {} // 기본 생성자

  // 매개변수가 있는 생성자
  public MyRetangle(double width, double height) {
    this.width = width;
    this.height = height;
    // this: 자기자신 (MyRetangle 클래스)
  }

  // 메소드
  public double calcArea() {
    return width * height;
  }



} // end MyRetangle

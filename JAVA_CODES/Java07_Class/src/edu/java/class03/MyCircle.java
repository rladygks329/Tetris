package edu.java.class03;

// 이름 변경 단축키 : alt + shift + R
public class MyCircle {
  private final static double PI = 3.14;

  double radius;

  public MyCircle() {}

  public MyCircle(double radius) {
    this.radius = radius;
  }

  public double calcArea() {
    return radius * radius * PI;
  }

}

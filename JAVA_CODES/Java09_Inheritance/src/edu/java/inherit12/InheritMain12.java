package edu.java.inherit12;

// abstract : 추상적인, 실체가 없는
// abstract 메서드(추상 메소드) :
// - 메소드의 원형(prototype : 리턴 타입, 이름, 매개변수)만 선언하고
// 메소드의 본체를 구현하지 않는 메소드 -> override를 강제함


// abstract 클래스 (추상 클래스):
// - 추상 메서드를 하나라도 가지고 있는 클래스
// - 선언타입
// abstract class 클래스이름{}
// -추상클래스는 인스턴스를 생성할 수 없음(생성자를 호출할 수 없음)
// -상송받는 클래스에서 메소드를 override하면 인스턴스를 생성할 수 있음

abstract class TestAbstract {// 부모의 역할(독립적인 사용x)
  // 멤버 변수
  private int x;

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  // 추상 메소드: 본체가 없는 메소드
  public abstract void hello();
}// end TestAbstract


class TestChild extends TestAbstract {
  @Override
  public void hello() {
    System.out.println("안녕하세요");
  }
}


public class InheritMain12 {
  public static void main(String args[]) {
    // 추상 클래스는 인스턴스를 생성할 수 없음
    // TestAbstract test1 = new TestAbstract();

    TestChild child = new TestChild();
    child.setX(100);
    System.out.println("x = " + child.getX());
    child.hello();

  } // end main
}// end InheritMain

package edu.java.inherit01;

// BasicTv : 상위 클래스 (super class), 부모 클래스 (parent class), 기본 클래스(base class)
// SmartTv : 하위 클래스 (sub class), 자식 클래스 (child class), 유도 클래스(derived class)

public class InheritMain01 {

  public static void main(String[] args) {
    // SmartTv 클래스의 인스턴스 생성
    SmartTv tv1 = new SmartTv();
    tv1.powerOn = true;
    tv1.turnOnOff();
    tv1.setIp("172.16.3.1");

    BasicTv tv2 = new BasicTv();
    // tv2.setIp("") // 부모 클래스가 자식 클래스의 메소드를 사용할 수 없음.
  } // end main()

} // end InheritMain01

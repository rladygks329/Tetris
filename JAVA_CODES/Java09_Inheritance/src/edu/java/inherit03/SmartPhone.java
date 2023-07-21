package edu.java.inherit03;

public class SmartPhone extends Phone {
  // 생성자
  // -자식클래스의 생성자가 호출되면,
  // 부모클래스의 생성자가 먼저 실행된 후에 자식 클래스의 코드들이 실행됨
  // 1) 부모 클래스의 생성자를ㄹ 명시적으로 호출하지 않을 때는 super()가 자동으로 호출
  // 2) 부모 클래스의 생성자를 명시적으로 super(); 또는 super(매개변수); 로 호출 가능
  // - 만약에 부모 클래스가 기본 생성자를 가지고 있지않은 경우에는
  // super()가 자동으로 호출될 수 없기 때문에
  // 자식클래스의 생성자에서 super(매개변수)를 호출하는 코드가 반드시 있어야함
  public SmartPhone(String number) {
    super(number);
    System.out.println("Smart Phone(number) 생성자 호출");
  }
}

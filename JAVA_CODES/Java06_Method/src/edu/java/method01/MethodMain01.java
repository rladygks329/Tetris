package edu.java.method01;

// 메소드: 기능을 수행하기 위한 코드. 주로 반복적인 기능을 수행할 때 사용.
// - 메소드는 클래스 안에서. 다른 메소드 외부에서 만든다.
// - 주의 메소드 안에 또 다른 메소드를 만들 수 없음
// 수식어 : public, protected, private, static
// 리턴타입, 매개변수 {본문}

public class MethodMain01 {


  public static void sayHello(String name) {

    System.out.println("Hi");
    System.out.println("I'm " + name);
  } // end sayHello()

  public static void sayAge(int age) {
    System.out.println("제 나이는" + age + "입니다!");
  } // end sayAge()

  // static 수식어 : 프로그램이 실행될 떼 생성하도록 선언하는 키워드
  // static 메소드에서는 static으로 선언된 메소드만 호출 가능
  public static void main(String[] args) {
    System.out.println("Hello");
    System.out.println("Bye");
    sayHello("kim");

    StringBuilder sb = new StringBuilder();
  } // end Main()

} // end MethodMain01

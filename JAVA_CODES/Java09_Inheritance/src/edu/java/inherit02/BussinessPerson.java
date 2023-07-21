package edu.java.inherit02;

public class BussinessPerson extends Person {
  private String company;

  public BussinessPerson() {
    // super(); 부모 클래스의 기본 생성자 호출 -> 생략 가능
    // super() == Person()
    System.out.println("BusinessPerson() 생성자");
  }

  public BussinessPerson(String name) {
    super(name); // 만약 부모 클래스의 매개변수 생성자를
    // 명시적으로 호출한 경우 -> 생략 불가
    System.out.println("BusinessPerson(name) 생성자");
  }

  public String getCompany() {
    return company;
  }
}

package edu.java.access07;

public class MyNumber {
  // 멤버 변수
  private int number;

  // 생성자
  public MyNumber(int number) {
    this.number = number;
  }

  // private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
  public int getNumber() {
    return number;
  }

  // private 멤버 변수를 간접적으로 변경하는 메소드 - setter
  public void setNumber(int number) {
    this.number = number;
  }

  // 기능 : 현재 객체(this : MyNumber)의 number 변수와 매개 변수 number를 더한 후, 현재 객체의 number에 저장
  // @return : MyNumber
  // @name: add
  // @args: MyNbumber number
  public MyNumber add(MyNumber number) {
    this.number = this.number + number.getNumber();
    return this;
  } // end add;

} // end MyNumber

package edu.java.inner06;

interface PersonInterface {
  public abstract void showInfo();

  public abstract void hello();
} // end PersonInterface


class Person {
  private String name; // 멤버 변수

  // 생성자
  public Person(String name) {
    this.name = name;
  }

  public PersonInterface setAge(int age) {
    // 지역 클래스
    class PersonWithAge implements PersonInterface {
      private int age;

      public PersonWithAge(int age) {
        this.age = age;
      }

      public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
      }// end showInfo()

      @Override
      public void hello() {
        System.out.println("안녕하세요");
      } // end hello()
    }// end PersonWithAge

    // 지역 클래스 객체(내용)을 모두 저장
    PersonWithAge instance = new PersonWithAge(age);
    // 지역 클래스 객체(내용)을 리턴
    return instance;
  }// end setAge()
} // end Person


public class InnerClass06 {

  public static void main(String[] args) {
    Person p1 = new Person("james");
    PersonInterface p2 = p1.setAge(10);
    p2.showInfo();
    p2.hello();

  } // end main()

} // end InnerClass06

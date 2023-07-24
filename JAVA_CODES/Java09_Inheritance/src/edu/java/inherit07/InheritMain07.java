package edu.java.inherit07;

class ParentClass {
  private int x;

  public ParentClass(int x) {
    this.x = x;
    System.out.println("Parentclass(x) 생성자");
  }

  public int getX() {
    return x;
  }

} // end ParentClass


class ChildClass extends ParentClass {
  private int y;

  public ChildClass(int x, int y) {
    super(x);
    this.y = y;
    System.out.println("child class (x,y) 생성자");
  }

  public int getY() {
    return y;
  }
}


public class InheritMain07 {

  public static void main(String[] args) {
    ParentClass class1 = new ChildClass(0, 0); // 다형성
    ChildClass class2 = new ChildClass(300, 400);
    ParentClass class3 = new ParentClass(400);

    class2.getX();
    class2.getY();

    class1.getX();
    // class1.getY();
    // class1은 ParentClass 타입으로 선언했기 때문에 자식의 메소드를 사용 불가
    // 그러나 실제로는 ChildClass 이기 때문에 형변환을 하면 사용할 수 있음

    System.out.println(((ChildClass) class1).getY());
    // ChildClass c = (ChildClass) class1;
    // System.out.println(c.getY());

    ParentClass[] ps = new ParentClass[3];
    ps[0] = class1;
    ps[1] = class2;
    ps[2] = class3;

    // instanceof 키워드
    // - 기본형태
    // 참조변수 instanceof 클래스 이름
    // -명시한 클래스 타입의 인스턴스와 같으면 true, 아니면 false를 리턴하는 키워드
    // - 특정 인스턴스가 실제 어떤 클래스인지 확인할 때 사용
    System.out.println(class1 instanceof ChildClass);

    for (int i = 0; i < ps.length; i++) {
      if (ps[i] instanceof ChildClass) {
        System.out.println("-----------------");
        System.out.println(ps[i].getX());
        System.out.println(((ChildClass) ps[i]).getY());
      } else {
        System.out.println(ps[i].getX());
      }
    }

  } // end main()


} // end InheritMain

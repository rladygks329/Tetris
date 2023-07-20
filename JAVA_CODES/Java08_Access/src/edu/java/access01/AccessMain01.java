package edu.java.access01;

// 접근 제한 수식어 (Access Modifier)
// 1. 종류: private, (pakage), protected, public
// 2. 기능:
// 1) 멤버 변수에 대한 접근 권한을 설정
// 2) 메소드에 대한 접근 권한을 설정
// 3) 생성자에 대한 접근 권한을 설정
// 4) 클래스에 대한 접근 권한을 설정(pakage, public만 사용가능)
//
// 3. 종류 및 의미:
// 1) private: 선언된 클래스 안에서 직접 접근(사용)이 가능
// 2) (pakage): 같은 패키지에 있는 클래스에서 직접 접근(사용)이 가능
// 3) protected : 같은 패키지에 있거나 상속받는 클래스들에서 직접 접근(사용)이 가능
// 4) public: 어디서든지 직접 접근(사용) 가능
//
// 4. 사용범위: private < pakage < protected < public
public class AccessMain01 {
  public static void main(String[] args) {
    Test01 t1 = new Test01();
    // t1.n1 = 100; //컴파일 에러
    // private 멤버 변수는 다른 클래스에서 직접 접근이 불가능(보이지 않음)
    // -> 값을 변경하거나 읽어오지 못함

    t1.n2 = 200; // (pakage) : 같은 패키지에 있기 때문에 접근 가능
    t1.n3 = 300; // protected : 같은 패키지에 있기 때문에 접근 가능
    t1.n4 = 400; // public : 어디서든지 접근 가능

    t1.printFields();

  }// end main()

}// end AccessMain01

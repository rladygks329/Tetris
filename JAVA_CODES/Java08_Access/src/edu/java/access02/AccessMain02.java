package edu.java.access02;

import java.util.Scanner;
import edu.java.access01.Test01;

public class AccessMain02 {

  public static void main(String[] args) {
    // Ctrl + shift + o : 자동 import
    Scanner sc = new Scanner(System.in);
    Test01 t1 = new Test01();

    // t1.n1 = 100; // private 접근 불가
    // t1.n2 = 200;// (pakage) : 다른 패키지에 있으므로 접근 불가
    // t1.n3 = 300; // protected : 다른 패키지이고, 상속받지 않았으므로 접근 불가

    t1.n4 = 400; // public: 어디서든지 접근 가능
    t1.printFields();
  }

}

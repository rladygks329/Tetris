package edu.java.while03;

// do - while
// - 무조건 한 번 본문을 실행한 후
// 반복문의 조건에 따라 반복 실행
// - 선언형태
// do {
//
// }while(
//
// )
public class WhileMain03 {

  public static void main(String[] args) {
    System.out.println("do-while");

    int count = 0;

    // 출력되지 않는다.
    while (count > 0) {
      System.out.println(count--);
    }

    // 한번 출력1
    do {
      System.out.println(count--);
    } while (count > 0);
  } // end main()

} // end WhileMain01

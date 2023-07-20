package edu.java.access04;

public class AccessMain04 {

  public static void main(String[] args) {
    // 객체 생성 및 데이터 저장 방식 1
    Contact c1 = new Contact(0, "유재석", "010-2222-2222", "you@gamil.com");
    System.out.println(c1.toString());

    // 전화번호 변경
    c1.setPhone("010-1111-1111");
    System.out.println(c1.toString());

    // 객체 생성 및 데이터 저장 방식2
    Contact c2 = new Contact();
    System.out.println(c2.toString());

    c2.setNo(2);
    c2.setName("박명수");
    c2.setPhone("010-3333-3333");
    c2.setEmail("park@gmail.com");
    System.out.println(c2.toString());

    // 3 명의 연락처 정보를 배열로 묶음
    Contact[] contacts = new Contact[3];

    // 유재석의 정보를 contacts[0]에 저장
    contacts[0] = c1;
    // 박명수의 정보를 contacts[1]에 저장
    contacts[1] = c2;
    // 아이유의 정보를 contacts[2]에 저장
    contacts[2] = new Contact(3, "아이유", "010-2222-2222", "iu@gamil.com");

    for (Contact c : contacts) {
      System.out.println(c.toString());
    }


  } // end main()

}// end AccessMain04

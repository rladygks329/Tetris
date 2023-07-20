package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
  public static final int MAX = 100; // 연락처 최대 저장 개수

  // 연락처 저장 배열
  public static Contact[] contactList = new Contact[MAX];
  public static int count = 0;
  public static Scanner sc = new Scanner(System.in);

  public static final int MENU_QUIT = 0; // 종료
  public static final int MENU_INSERT = 1; // 등록
  public static final int MENU_DISPLAY = 2; // 전체보기
  public static final int MENU_SEARCH = 3; // 검색
  public static final int MENU_UPDATE = 4; // 수정
  public static final int MENU_DELETE = 5; // 삭제

  public static void main(String[] args) {
    System.out.println("연락처(Contact) 프로그램 ver 0.1 ");

    int input = 1;

    while (input != MENU_QUIT) {
      System.out.println("----------------------------------------------------------------");
      System.out.println("1 등록 | 2.전체 검색 | 3. 상세검색 | 4.수정 | 5.삭제 | 0. 종료");
      System.out.println("----------------------------------------------------------------");
      System.out.print("선택> ");
      input = sc.nextInt();

      switch (input) {
        case MENU_INSERT:
          addContact();
          break;
        case MENU_DISPLAY:
          displayContacts();
          break;
        case MENU_SEARCH:
          searchContact();
          break;
        case MENU_UPDATE:
          updateContact();
          break;
        case MENU_DELETE:
          deleteContact();
          break;
        case MENU_QUIT:
          System.out.println("프로그램을 종료합니다.");
          break;
        default:
          System.out.println("0 - 5 까지의 숫자를 입력해주세요");
          break;
      }

    }
    System.out.println();

  } // main()

  public static void addContact() {
    System.out.print("이름>");
    String newName = sc.next();

    System.out.print("전화번호>");
    String newPhone = sc.next();

    System.out.print("이메일>");
    String newEmail = sc.next();

    Contact newContact = new Contact(newName, newPhone, newEmail);
    contactList[count++] = newContact;
  }

  public static void displayContacts() {
    System.out.println("[전체 정보 출력]");
    for (int i = 0; i < count; i++) {
      System.out.println(i + " : " + contactList[i].toString());
    }
  }

  public static void updateContact() {
    System.out.println("변경하고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (count - 1) + " )");
    int index = sc.nextInt();
    checkIndex(index);

    System.out.print("이름>");
    String newName = sc.next();
    System.out.print("전화번호>");
    String newPhone = sc.next();
    System.out.print("이메일>");
    String newEmail = sc.next();

    Contact updatedContact = new Contact(newName, newPhone, newEmail);
    contactList[index] = updatedContact;
  }

  public static void searchContact() {
    System.out.println("찾고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (count - 1) + " )");
    int index = sc.nextInt();

    if (checkIndex(index)) {
      System.out.println(contactList[index].toString());
    } ;
  }

  public static void deleteContact() {
    System.out.println("삭제하고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (count - 1) + " )");
    int index = sc.nextInt();

    if (checkIndex(index)) {
      for (int i = index; i < count; i++) {
        contactList[i] = contactList[i + 1];
        count--;
      }
    }
  }

  public static boolean checkIndex(int n) {
    if (n < 0 || count <= n) {
      System.out.println("올바른 값을 입력해주세요");
      System.out.println("0 ~ " + (count - 1));
      return false;
    }
    return true;
  }

}// endMain()

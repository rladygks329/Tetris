package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
  public static final int MAX = 100; // 연락처 최대 저장 개수

  // 연락처 저장 배열
  public static Contact[] contactList = new Contact[MAX];
  public static int size = 0;
  public static Scanner sc = new Scanner(System.in);

  public static final int MENU_INIT = -1; // 시작
  public static final int MENU_QUIT = 0; // 종료
  public static final int MENU_INSERT = 1; // 등록
  public static final int MENU_SELECT_ALL = 2; // 전체보기
  public static final int MENU_SEARCH = 3; // 검색
  public static final int MENU_UPDATE = 4; // 수정
  public static final int MENU_DELETE = 5; // 삭제

  public static void main(String[] args) {
    System.out.println("연락처(Contact) 프로그램 ver 0.1 ");

    int input = MENU_INIT;

    while (input != MENU_QUIT) {
      showMainMenu();
      input = sc.nextInt();

      switch (input) {
        case MENU_INSERT:
          insertContact();
          break;
        case MENU_SELECT_ALL:
          selectAllContacts();
          break;
        case MENU_SEARCH:
          selectContact();
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

    } // end while

  } // main()

  private static void showMainMenu() {
    System.out.println("----------------------------------------------------------------");
    System.out.println("1 등록 | 2.전체 검색 | 3. 상세검색 | 4.수정 | 5.삭제 | 0. 종료");
    System.out.println("----------------------------------------------------------------");
    System.out.print("선택> ");
  } // end showMainMenu()

  private static void insertContact() {
    System.out.println("-----------------");
    System.out.println("연락처 등록 메뉴");
    System.out.println("-----------------");

    System.out.print("이름>");
    String newName = sc.next();

    System.out.print("전화번호>");
    String newPhone = sc.next();

    System.out.print("이메일>");
    String newEmail = sc.next();

    Contact newContact = new Contact(newName, newPhone, newEmail);
    contactList[size++] = newContact;
    System.out.println("연락처 등록 완료");
    System.out.println("등록된 연락처 개수 : " + size);
  } // end insertContact()

  private static void selectAllContacts() {
    System.out.println("[전체 정보 출력]");
    for (int i = 0; i < size; i++) {
      System.out.println("--- 연락처 " + i + " ---");
      System.out.println(contactList[i]);
    }
  } // end displayContacts()

  private static void updateContact() {
    System.out.println("----------------------------------------------------------------");
    System.out.println("변경하고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (size - 1) + " )");
    int index = sc.nextInt();

    if (index >= 0 && index < size) {
      System.out.print("이름>");
      String name = sc.next();
      System.out.print("전화번호>");
      String phone = sc.next();
      System.out.print("이메일>");
      String email = sc.next();

      contactList[index].setName(name);
      contactList[index].setPhone(phone);
      contactList[index].setEmail(email);
    } else {
      System.out.println("해당하는 회원이 없습니다.");
    }

  } // end updateContact()

  private static void selectContact() {
    System.out.println("찾고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (size - 1) + " )");
    int index = sc.nextInt();

    if (index >= 0 && index < size) {
      System.out.println(contactList[index].toString());
    } else {
      System.out.println("해당하는 회원이 없습니다.");
    }
  } // end updateContact()

  private static void deleteContact() {
    System.out.println("삭제하고자 하는 연락처의 인덱스를 입력하세요 (0 ~ " + (size - 1) + " )");
    int index = sc.nextInt();

    if (index >= 0 && index < size) {
      for (int i = index; i < size; i++) {
        contactList[i] = contactList[i + 1];
      }
      contactList[size--] = null;
    } else {
      System.out.println("해당하는 회원이 없습니다.");
    }

  } // end deleteContact()

}// endMain()

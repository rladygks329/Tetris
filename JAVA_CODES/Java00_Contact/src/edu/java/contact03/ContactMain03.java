package edu.java.contact03;

import java.util.List;
import java.util.Scanner;

public class ContactMain03 {

  private static Scanner sc;
  private static ContactDAO dao;

  public static void main(String[] args) {
    System.out.println("연락처 관리 프로그램 ver 0.3");
    sc = new Scanner(System.in);
    dao = ContactDAOIMple.getInstance();
    boolean run = true;

    while (run) {
      showMainMenu();
      int choice = sc.nextInt();
      switch (choice) {
        case Menu.INSERT:
          insertContact();
          break;
        case Menu.SELECT_ALL:
          selectAllContact();
          break;
        case Menu.SELECT_BY_INDEX:
          selectContactByIndex();
          break;
        case Menu.UPDATE:
          updateContact();
          break;
        case Menu.DELETE:
          deleteContact();
          break;
        case Menu.QUIT:
          System.out.println("프로그램을 종료합니다.");
          run = false;
          break;
        default:
          System.out.println("올바른 값을 선택해주세요");
          break;
      }
    }
  } // end main()

  private static void showMainMenu() {
    System.out.println("---------------------------------------------------------------");
    System.out.println("1 등록 | 2.전체 검색 | 3. 상세검색 | 4.수정 | 5. 삭제 | 0. 종료");
    System.out.println("---------------------------------------------------------------");
    System.out.print("선택> ");
  } // end showMainMenu()

  private static void insertContact() {
    System.out.println("--- 연락처 등록 메뉴 ---");
    System.out.println("이름을 입력하세요");
    String name = sc.next();
    System.out.println("전화번호 입력하세요");
    String phone = sc.next();
    System.out.println("이메일을 입력하세요");
    String email = sc.next();

    ContactDTO contact = new ContactDTO(name, phone, email);
    int result = dao.insert(contact);
    int size = ((ContactDAOIMple) dao).getSize();
    if (result == 1) {
      System.out.println("등록된 연락처 갯수: " + size);
    } else {
      System.out.println("연락처 등록에 문제가 생겼습니다.");
    }
  } // insertContact

  private static void selectAllContact() {
    System.out.println("연락처 전체 정보");
    List<ContactDTO> list = dao.select();

    for (int i = 0; i < list.size(); i++) {
      System.out.println("연락처[" + i + "]: " + list.get(i));
    }
  } // end selectAllContact

  private static void selectContactByIndex() {
    System.out.println("인덱스를 입력하세요");
    int index = sc.nextInt();
    int size = ((ContactDAOIMple) dao).getSize();
    if (index < 0 || size <= index) {
      System.out.println("해당하는 연락처 정보가 없습니다.");
      return;
    }
    System.out.println(dao.select(index));
  }// end selectContactByIndex

  private static void updateContact() {
    System.out.println("인덱스를 입력하세요");
    int index = sc.nextInt();
    int size = ((ContactDAOIMple) dao).getSize();

    if (index < 0 || size <= index) {
      System.out.println("해당하는 연락처 정보가 없습니다.");
      return;
    }

    System.out.println("전화번호 입력하세요");
    String phone = sc.next();
    System.out.println("이메일을 입력하세요");
    String email = sc.next();

    int result = dao.update(index, new ContactDTO("", phone, email));
    if (result == 1) {
      System.out.println("연락처 수정에 성공하였습니다.");
    }
  } // end updateContact

  private static void deleteContact() {
    System.out.println("인덱스를 입력하세요");
    int index = sc.nextInt();
    int size = ((ContactDAOIMple) dao).getSize();

    if (index < 0 || size <= index) {
      System.out.println("해당하는 연락처 정보가 없습니다.");
      return;
    }

    int result = dao.delete(index);
    if (result == 1) {
      System.out.println("삭제에 성공하였습니다.");
    } else {
      System.out.println("삭제에 실패했습니다.");
    }

  }// end deleteContact

} // end ContactMain03()

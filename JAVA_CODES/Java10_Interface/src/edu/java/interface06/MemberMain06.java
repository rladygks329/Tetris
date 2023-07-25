package edu.java.interface06;

import java.util.Scanner;

// MVC 디자인 패턴에서 view 클래스
// - UI를 담당하는 역할
public class MemberMain06 {

  private static Scanner sc;
  private static MemberDAO dao; // MemberDaoImple 인스턴스를 저장할 변수

  public static void main(String[] args) {
    System.out.println("회원 관리 프로그램");
    sc = new Scanner(System.in);
    dao = MemberDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성

    boolean run = true;
    while (run) {
      showMainMenu();
      int choice = sc.nextInt();
      switch (choice) {
        case Menu.INSERT:
          insertMember();
          break;
        case Menu.SELECT_ALL:
          selectAll();
          break;
        case Menu.SELECT_BY_INDEX:
          selectByIndex();
          break;
        case Menu.UPDATE:
          updateMember();
          break;
        case Menu.QUIT:
          run = false;
          break;
        default:
          System.out.println("다시 선택하세요");
          break;
      }
    }

  } // end main()

  private static void showMainMenu() {
    System.out.println("========================================================");
    System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 0. 종료");
    System.out.println("=========================================================");
    System.out.println("선택>");
  } // end showMainMenu

  private static void insertMember() {
    System.out.println();
    System.out.println(" --- 회원 정보 등록 --- ");
    System.out.println("아이디 입력>");
    String id = sc.next();
    System.out.println("비밀번호 입력>");
    String pw = sc.next();
    System.out.println("이메일 입력>");
    String email = sc.next();

    int result = dao.insert(new MemberDTO(id, pw, email));
    if (result == 1) {
      System.out.println("회원 정보 등록 완료");
    }
  } // end insertMember

  private static void selectAll() {
    MemberDTO[] list = dao.select();
    int size = ((MemberDAOImple) dao).getSize();

    for (int i = 0; i < size; i++) {
      System.out.println("회원정보[" + i + "]");
      System.out.println(list[i]);
    }
  } // end selectAll

  private static void selectByIndex() {
    System.out.println();
    System.out.println("검색할 인덱스 입력>");

    int index = sc.nextInt();
    int size = ((MemberDAOImple) dao).getSize();
    if (0 <= index && index < size) {
      System.out.println(dao.select(index));
    } else {
      System.out.println("존재하지 않는 인덱스 입니다.");
    }
  } // end selectByIndex

  private static void updateMember() {
    System.out.println();
    System.out.println("회원 정보 수정");
    System.out.println("인덱스 입력>");

    int index = sc.nextInt();
    int size = ((MemberDAOImple) dao).getSize();

    if (index < 0 || size <= index) {
      System.out.println("존재하지 않는 인덱스 입니다.");
      return;
    }

    System.out.println("비밀번호 입력>");
    String pw = sc.next();
    System.out.println("이메일 입력>");
    String email = sc.next();

    int result = dao.update(index, new MemberDTO("", pw, email));
    if (result == 1) {
      System.out.println("회원 정보 수정 완료");
    }
  } // end updateMember

} // end MemberMain06

package edu.java.class03;

public class MemberService {

  public MemberService() {}

  public boolean logIn(String id, String password) {
    return id.equals("hong") && password.equals("12345");
  }

  public void logOut(String id) {
    System.out.println(id + "님이 로그아웃 하셨습니다.");
  }
}

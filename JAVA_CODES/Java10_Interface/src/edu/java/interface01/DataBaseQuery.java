package edu.java.interface01;

public interface DataBaseQuery {
  // 인터페이스의 멤버 변수 : public static final
  public static final int DATABASE_VERSION = 1;

  // 인터페이스의 메소드 : public abstract
  public abstract int insert(String id, String pw);

}

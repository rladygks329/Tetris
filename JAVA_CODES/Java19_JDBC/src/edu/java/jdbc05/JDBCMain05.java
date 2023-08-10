package edu.java.jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMain05 {

  // 1. DB연결에 사용할 상수들
  public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
  public static final String USER = "scott";
  public static final String PASSWORD = "tiger";

  public static final String TABLE_NAME = "EX_CONTACT";
  public static final String COL_CONTACT_ID = "CONTACT_ID";
  public static final String COL_NAME = "NAME";
  public static final String COL_PHONE = "PHONE";
  public static final String COL_EMAIL = "EMAIL";

  // 연락처 데이터 등록
  // INSER INTO EX_CONTACT
  // VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?);
  public static final String SQL_INSERT =
      "INSERT INTO " + TABLE_NAME + " VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?)";

  public static void main(String[] args) {
    System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");

    Connection conn = null;
    PreparedStatement pstmt = null;
    // PreparedStatement : 매개변수를 갖고 있는 sql 문장을 활용하기 위한 클래스 Statement와 상속관계

    try {
      // 2. Oracle JDBC 드라이버를 메모리에 로드
      System.out.println("드라이버 로드 성공");

      // 3. DB와 Connection (연결)을 맺음
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("DB 연결 성공");

      // 4. Connection 객체를 사용하여 PreparedStatenent 객체를 생성
      pstmt = conn.prepareStatement(SQL_INSERT);

      Scanner sc = new Scanner(System.in);
      System.out.println("이름 입력>");
      String name = sc.next();

      System.out.println("전화번호 입력>");
      String phone = sc.next();

      System.out.println("이메일 입력>");
      String email = sc.next();

      // 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
      pstmt.setString(1, name);
      pstmt.setString(2, phone);
      pstmt.setString(3, email);
      // SQL 쿼리의 ? 순서와 parameterIndex의 값을 동일하게 지정
      // 예시 ) ? 가 첫 번째면 parameterInder = 1

      // setInt() : DB의 Number 타입
      // setString() : DB의 varchar, varchar2 타입
      // setFloat() : DB의 Float 타입
      // setDate() : DB의 Date 타입



      // 6. SQL 문장 실행 (DB서버로 SQL 전송)
      int result = pstmt.executeUpdate();

      // 7. 처리 결과 확인
      System.out.println(result + "행이 삽입되었습니다.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  } // end main()
}// end JDBCMain05

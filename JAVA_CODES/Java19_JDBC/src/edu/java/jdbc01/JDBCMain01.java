package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC : Java DataBase Connection
// C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib

// 프로젝트에 폴더생성
// 폴더 jar 파일을 lib에 복사
// jar을 build path에 추가

// 1. db에 연동하기 위해 필요한 상수들을 정의
// 2. jdbc 드라이버를 메모리에 로드
// 3. db랑 connection을 맺음
// 4. connection 객체를 사용해서 statement 객체를 생성
// 5. sql 문장을 생성
// 6. statement 객체를 사용하여 sql 실행 db서버로 sql 문장 전송
// 7. db 서버가 보내준 결과를 확인 / 처리

public class JDBCMain01 {

  // 1. DB연결에 사용할 상수들
  public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
  public static final String USER = "scott";
  public static final String PASSWORD = "tiger";

  public static final String TABLE_NAME = "EX_CONTACT";
  public static final String COL_CONTACT_ID = "CONTACT_ID";
  public static final String COL_NAME = "NAME";
  public static final String COL_PHONE = "PHONE";
  public static final String COL_EMAIL = "EMAIL";

  public static void main(String[] args) {
    System.out.println("JDBC 1 - insert");

    Connection conn = null;
    Statement stmt = null;

    try {
      // 2. Oracle JDBC 드라이버를 메모리에 로드

      System.out.println("드라이버 로드 성공");

      // 3. DB와 Connection (연결)을 맺음
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("DB 연결 성공");

      // 4. Connection 객체를 사용하여 Statenent 객체를 생성
      stmt = conn.createStatement();

      // 5. SQL 문장 작성
      String sql_insert = "INSERT INTO " + TABLE_NAME
          + " VALUES(CONTACT_SEQ.NEXTVAL, 'AAA', '02-000-2929', 'TEST@NAVER.COM')";
      System.out.println(sql_insert);

      // 6. SQL 문장 실행 (DB서버로 SQL 전송)
      int result = stmt.executeUpdate(sql_insert);
      System.out.println(result + "행이 삽입되었습니다.");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  } // end main()

} // end JDBCMain01

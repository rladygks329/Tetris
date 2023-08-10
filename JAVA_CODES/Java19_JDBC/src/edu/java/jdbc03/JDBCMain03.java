package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCMain03 {

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
    System.out.println("JDBC 3 - Select all");


    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();) {
      // 2. Oracle JDBC 드라이버를 메모리에 로드
      // 3. DB와 Connection (연결)을 맺음
      // 4. Connection 객체를 사용하여 Statenent 객체를 생성
      System.out.println("드라이버 로드 성공");
      System.out.println("DB 연결 성공");

      // 5. SQL 문장 작성
      // SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID;
      String sql_select = //
          "SELECT * FROM " + TABLE_NAME //
              + " ORDER BY " + COL_CONTACT_ID;
      System.out.println(sql_select);

      // 6. SQL 문장 실행 (DB서버로 SQL 전송)
      ArrayList<ContactDTO> list = new ArrayList<>();
      try (ResultSet rs = stmt.executeQuery(sql_select);) {
        // 7. DB서버가 보낸 결과 확인/처리
        // ResultsSet.next() : 다음 행이 있으면 리턴하고 ResultSet이 다음 위치를 가르킨다
        while (rs.next()) { // 레코드가 존재할 동안 반복
          int contactId = rs.getInt(1); // CONTACT_ID 컬럼
          String name = rs.getString(2); // NAME 컬럼
          String phone = rs.getString(3); // PHONE 컬럼
          String email = rs.getString(4);// EMAIL 컬럼
          ContactDTO dto = new ContactDTO(contactId, name, phone, email);
          list.add(dto);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      for (ContactDTO dto : list) {
        System.out.println(dto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // end main()

} // end JDBCMain02

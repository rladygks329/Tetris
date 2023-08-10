package edu.java.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import edu.java.jdbc03.ContactDTO;

public class JDBCMain07 {

  // 1. DB연결에 사용할 상수들
  public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
  public static final String USER = "scott";
  public static final String PASSWORD = "tiger";

  public static final String TABLE_NAME = "EX_CONTACT";
  public static final String COL_CONTACT_ID = "CONTACT_ID";
  public static final String COL_NAME = "NAME";
  public static final String COL_PHONE = "PHONE";
  public static final String COL_EMAIL = "EMAIL";

  // 5. SQL 문장 작성
  // SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID WHRERE CONTACT_ID = ?;
  public static final String SQL_SELECT_BY_CONTACT_ID = //
      "SELECT * FROM " + TABLE_NAME + //
          " WHERE " + COL_CONTACT_ID + " = ?";

  public static void main(String[] args) {
    System.out.println("JDBC 4 - Select By Index");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      // 2. Oracle JDBC 드라이버를 메모리에 로드
      System.out.println("드라이버 로드 성공");

      // 3. DB와 Connection (연결)을 맺음
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("DB 연결 성공");

      // 4. Connection 객체를 사용하여 Statenent 객체를 생성
      pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
      Scanner sc = new Scanner(System.in);
      System.out.println();
      int contactId = sc.nextInt();
      sc.close();
      pstmt.setInt(1, contactId);
      // 6. SQL 문장 실행 (DB서버로 SQL 전송)
      rs = pstmt.executeQuery();

      if (rs.next()) { // 레코드가 존재할 동안 반복
        contactId = rs.getInt(1);
        String name = rs.getString(2); // NAME 컬럼
        String phone = rs.getString(3); // PHONE 컬럼
        String email = rs.getString(4);// EMAIL 컬럼
        ContactDTO dto = new ContactDTO(contactId, name, phone, email);
        System.out.println(dto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

  } // end main()

}// end JDBCMain07

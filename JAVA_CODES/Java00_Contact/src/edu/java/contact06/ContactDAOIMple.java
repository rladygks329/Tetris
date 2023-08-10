package edu.java.contact06;

import static edu.java.contact06.OracleQuery.PASSWORD;
import static edu.java.contact06.OracleQuery.SQL_DELETE;
import static edu.java.contact06.OracleQuery.SQL_INSERT;
import static edu.java.contact06.OracleQuery.SQL_SELECT_ALL;
import static edu.java.contact06.OracleQuery.SQL_SELECT_BY_CONTACT_ID;
import static edu.java.contact06.OracleQuery.SQL_UPDATE;
import static edu.java.contact06.OracleQuery.URL;
import static edu.java.contact06.OracleQuery.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOIMple implements ContactDAO {
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static ContactDAOIMple instance;

  private ContactDAOIMple() {}

  public static ContactDAOIMple getInstance() {
    if (instance == null) {
      instance = new ContactDAOIMple();
    }

    return instance;
  }



  @Override
  public int insert(ContactDTO dto) {
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_INSERT);

      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getPhone());
      pstmt.setString(3, dto.getEmail());
      int result = pstmt.executeUpdate();
      return result;
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
    return -1;
  }

  @Override
  public List<ContactDTO> select() {
    List<ContactDTO> list = new ArrayList<>();
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SELECT_ALL);
      rs = pstmt.executeQuery();

      while (rs.next()) { // 레코드가 존재할 동안 반복
        int contactId = rs.getInt(1); // CONTACT_ID 컬럼
        String name = rs.getString(2); // NAME 컬럼
        String phone = rs.getString(3); // PHONE 컬럼
        String email = rs.getString(4);// EMAIL 컬럼
        ContactDTO dto = new ContactDTO(contactId, name, phone, email);
        list.add(dto);
      }
      return list;
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
    return list;
  }

  @Override
  public ContactDTO select(int contactId) {
    ContactDTO result;
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
      pstmt.setInt(1, contactId);
      rs = pstmt.executeQuery();

      if (!rs.next()) { // 레코드가 없으면 null 리턴
        return null;
      }

      int id = rs.getInt(1); // CONTACT_ID 컬럼
      String name = rs.getString(2); // NAME 컬럼
      String phone = rs.getString(3); // PHONE 컬럼
      String email = rs.getString(4);// EMAIL 컬럼
      result = new ContactDTO(id, name, phone, email);
      return result;
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
    return null;
  }

  @Override
  public int update(int contactId, ContactDTO dto) {
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_UPDATE);

      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getPhone());
      pstmt.setString(3, dto.getEmail());
      pstmt.setInt(4, contactId);

      int result = pstmt.executeUpdate();
      return result;
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
    return -1;
  }

  @Override
  public int delete(int contactId) {
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_DELETE);

      pstmt.setInt(1, contactId);
      int result = pstmt.executeUpdate();
      return result;
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
    return -1;
  }
}

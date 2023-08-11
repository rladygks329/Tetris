package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleDriver;

public class ContactDAOIMple implements ContactDAO, OracleQuery {
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
    int result = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      DriverManager.registerDriver(new OracleDriver());
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_INSERT);

      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getPhone());
      pstmt.setString(3, dto.getEmail());
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }// end insert()

  @Override
  public List<ContactDTO> select() {
    List<ContactDTO> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      DriverManager.registerDriver(new OracleDriver());
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
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return list;
  }// end select()

  /*
   * args: int return : ContactDTO or null
   */
  @Override
  public ContactDTO select(int contactId) {
    // optional을 쓰면 더 좋을듯
    ContactDTO result = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      DriverManager.registerDriver(new OracleDriver());
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
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }// end select()

  @Override
  public int update(int contactId, ContactDTO dto) {
    int result = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      DriverManager.registerDriver(new OracleDriver());
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_UPDATE);

      pstmt.setString(1, dto.getName());
      pstmt.setString(2, dto.getPhone());
      pstmt.setString(3, dto.getEmail());
      pstmt.setInt(4, contactId);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }// end Update()

  @Override
  public int delete(int contactId) {
    int result = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      DriverManager.registerDriver(new OracleDriver());
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_DELETE);
      pstmt.setInt(1, contactId);
      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  } // end delete()

} // end closeConnection

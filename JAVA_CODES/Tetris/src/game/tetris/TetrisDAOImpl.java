package game.tetris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleDriver;

public class TetrisDAOImpl implements OracleQuery, TetrisDAO {
  private static TetrisDAOImpl instance;

  private TetrisDAOImpl() {
    try {
      DriverManager.registerDriver(new OracleDriver());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static TetrisDAOImpl getInstance() {
    if (instance == null) {
      instance = new TetrisDAOImpl();
    }
    return instance;
  }

  @Override
  public int insert(UserDTO dto) {
    int result = 0;
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(SQL_USER_INSERT)) {
      pstmt.setString(1, dto.getId());
      pstmt.setString(2, dto.getPassword());
      pstmt.setString(3, dto.getNickName());
      result = pstmt.executeUpdate();
    } catch (SQLIntegrityConstraintViolationException e1) {
      System.out.println("중복된 닉네임이나 ID가 있어 SQL 실행 중 오류가 발생했습니다.");
    } catch (Exception e2) {
      e2.printStackTrace();
    }
    return result;
  }

  @Override
  public int insert(int userNo, int score) {
    int result = 0;
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(SQL_SCORE_INSERT)) {
      pstmt.setInt(1, userNo);
      pstmt.setInt(2, score);
      result = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int update(UserDTO dto) {
    int result = 0;
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(SQL_USER_UPDATE)) {
      pstmt.setString(1, dto.getPassword());
      pstmt.setString(2, dto.getNickName());
      pstmt.setInt(3, dto.getNo());
      result = pstmt.executeUpdate();

    } catch (SQLIntegrityConstraintViolationException e1) {
      System.out.println("오류: 이미 존재하는 닉네임입니다.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int selectById(String id) {
    int result = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SELECT_USER_BY_ID);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = rs.getInt(1);
      }
    } catch (Exception e) {
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

    return result;
  }

  @Override
  public int selectByNickName(String nickName) {
    int result = 0;

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SELECT_USER_BY_NICKNAME);
      pstmt.setString(1, nickName);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = rs.getInt(1);
      }
    } catch (Exception e) {
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

    return result;

  }

  @Override
  public UserDTO select(String id, String password) {
    UserDTO result = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SIGN_IN);
      pstmt.setString(1, id);
      pstmt.setString(2, password);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        int userNo = rs.getInt(1);
        String userId = rs.getString(2);
        String userPassword = rs.getString(3);
        String userNickName = rs.getString(4);
        result = new UserDTO(userNo, userId, userPassword, userNickName);
      }
    } catch (Exception e) {
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
    return result;
  }

  @Override
  public List<ScoreDTO> selectAll() {
    List<ScoreDTO> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SCORE_SELECT_ALL);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        int score = rs.getInt(1);
        String nickName = rs.getString(2);
        Timestamp time = rs.getTimestamp(3);
        ScoreDTO dto = new ScoreDTO(score, nickName, time);
        list.add(dto);
      }
    } catch (Exception e) {
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
  public List<ScoreDTO> selectAll(int userNo) {
    List<ScoreDTO> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      pstmt = conn.prepareStatement(SQL_SCORE_SELECT_BY_USER_NO);
      pstmt.setInt(1, userNo);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        int score = rs.getInt(1);
        String nickName = rs.getString(2);
        Timestamp time = rs.getTimestamp(3);
        ScoreDTO dto = new ScoreDTO(score, nickName, time);
        list.add(dto);
      }
    } catch (Exception e) {
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
}

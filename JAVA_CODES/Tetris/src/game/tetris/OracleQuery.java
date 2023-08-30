package game.tetris;

public interface OracleQuery {
  public static final String IP_ADDRESS = "172.16.3.7";
  // public static final String IP_ADDRESS = "127.0.0.1";
  public static final String URL = "jdbc:oracle:thin:@" + IP_ADDRESS + ":1521:xe";
  public static final String USER = "scott";
  public static final String PASSWORD = "tiger";

  public static final String USER_TABLE_NAME = "TETRIS_USER";
  public static final String USER_COL_USER_NO = "USER_NO";
  public static final String USER_COL_USER_ID = "USER_ID";
  public static final String USER_COL_PASSWORD = "PASSWORD";
  public static final String USER_COL_NICKNAME = "NICKNAME";
  public static final String USER_ALIAS_RECORDCOUNT = "RECORDCOUNT";

  public static final String SCORE_TABLE_NAME = "TETRIS_SCORE";
  public static final String SCORE_COL_SCORE_NO = "SCORE_NO";
  public static final String SCORE_COL_USER_NO = "USER_NO";
  public static final String SCORE_COL_SCORE = "SCORE";
  public static final String SCORE_COL_REPLAY = "REPLAY";
  public static final String SCORE_COL_TIME = "TIME";

  // 유저 추가
  public static final String SQL_USER_INSERT =
      "INSERT INTO " + USER_TABLE_NAME + " VALUES(TETRIS_USER_SEQ.NEXTVAL, ?, ?, ?)";

  // 해당 유저의 비밀번호, 닉네임 업데이트
  public static final String SQL_USER_UPDATE =
      "UPDATE " + USER_TABLE_NAME + " SET " + USER_COL_PASSWORD + " = ?, " + USER_COL_NICKNAME
          + " = ? " + "WHERE " + USER_COL_USER_NO + " = ?";

  // 비밀번호와 아이디를 가진 사람 찾기
  public static final String SQL_SIGN_IN = "SELECT * FROM " + USER_TABLE_NAME //
      + " WHERE " + USER_COL_USER_ID + " = ? AND " + USER_COL_PASSWORD + " = ?";

  // 같은 아이디를 가진 사람 수 세기
  public static final String SQL_SELECT_USER_BY_ID = "SELECT COUNT(*) " + USER_ALIAS_RECORDCOUNT
      + " FROM " + USER_TABLE_NAME + " WHERE " + USER_COL_USER_ID + " = ?";

  // 같은 닉네임을 가진 사람 수 세기
  public static final String SQL_SELECT_USER_BY_NICKNAME =
      "SELECT COUNT(*) " + USER_ALIAS_RECORDCOUNT + " FROM " + USER_TABLE_NAME + " WHERE "
          + USER_COL_NICKNAME + " = ?";

  // 유저 삭제
  public static final String SQL_USER_DELETE =
      "DELETE " + USER_TABLE_NAME + " WHERE " + USER_COL_USER_NO + " = ?";

  // 기록 추가 (USER_NO, SCORE)
  public static final String SQL_SCORE_INSERT = "INSERT INTO " + SCORE_TABLE_NAME + "("
      + SCORE_COL_SCORE_NO + ", " + SCORE_COL_USER_NO + ", " + SCORE_COL_SCORE + ", "
      + SCORE_COL_REPLAY + ") VALUES(TETRIS_SCORE_SEQ.NEXTVAL, ?, ?, ?)";

  // 기록 삭제
  public static final String SQL_SCORE_DELETE =
      "DELETE " + SCORE_TABLE_NAME + " WHERE " + SCORE_COL_SCORE_NO + " = ?";

  // 모든 기록 보기
  public static final String SQL_SCORE_SELECT_ALL = //
      "SELECT " + SCORE_COL_SCORE_NO + ", " + SCORE_COL_SCORE + ", U." + USER_COL_NICKNAME + ", "
          + SCORE_COL_TIME + ", " + SCORE_COL_REPLAY + " "//
          + "FROM " + SCORE_TABLE_NAME + " S JOIN " + USER_TABLE_NAME
          + " U ON S.USER_NO = U.USER_NO "//
          + "ORDER BY " + SCORE_COL_SCORE + " DESC";//

  // 자신의 기록 보기
  public static final String SQL_SCORE_SELECT_BY_USER_NO = "SELECT " + SCORE_COL_SCORE_NO + ", "
      + SCORE_COL_SCORE + ", U." + USER_COL_NICKNAME + ", " + SCORE_COL_TIME + ", "
      + SCORE_COL_REPLAY//
      + " FROM " + SCORE_TABLE_NAME + " S JOIN " + USER_TABLE_NAME + " U ON S.USER_NO = U.USER_NO"//
      + " WHERE S." + SCORE_COL_USER_NO + " = ?"//
      + " ORDER BY " + SCORE_COL_SCORE + " DESC";//
}

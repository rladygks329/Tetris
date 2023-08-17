package game.tetris;

public interface TetrosDAO {
  public abstract int insert(UserDTO dto);

  public abstract int insert(ScoreDTO dto);

  public abstract int update(int userNo, UserDTO dto);

  public abstract int selectById();

  public abstract int selectByNickName();

  public abstract UserDTO select(String id, String password);

  public abstract ScoreDTO selectAll();

  public abstract ScoreDTO selectAll(int userNo);
}

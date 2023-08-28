package game.tetris;

import java.util.List;

public interface TetrisDAO {
  public abstract int insert(UserDTO dto);

  int insert(int userNo, ScoreDTO dto);

  public abstract int update(UserDTO dto);

  public abstract int selectById(String id);

  public abstract int selectByNickName(String nickName);

  public abstract UserDTO select(String id, String password);

  public abstract List<ScoreDTO> selectAll();

  public abstract List<ScoreDTO> selectAll(int userNo);

  public abstract int deleteScore(int scoreNo);

}

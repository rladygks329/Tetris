package game.tetris;

import java.util.Date;
import java.util.List;

public class ScoreDTO {
  private int scoreNo;
  private int score;
  private String nickName;
  private Date time;
  private List<ReplayAtom> replay;

  public ScoreDTO() {}

  public ScoreDTO(int scoreNo, int score, String nickName, Date time, List<ReplayAtom> replay) {
    this.scoreNo = scoreNo;
    this.score = score;
    this.nickName = nickName;
    this.time = time;
    this.replay = replay;
  }

  public final int getScoreNo() {
    return scoreNo;
  }

  public final void setScoreNo(int scoreNo) {
    this.scoreNo = scoreNo;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public final List<ReplayAtom> getReplay() {
    return replay;
  }

  public final void setReplay(List<ReplayAtom> replay) {
    this.replay = replay;
  }

  @Override
  public String toString() {
    return "ScoreDTO [scoreNo=" + scoreNo + ", score=" + score + ", nickName=" + nickName
        + ", time=" + time + ", replay=" + replay + "]";
  }

}

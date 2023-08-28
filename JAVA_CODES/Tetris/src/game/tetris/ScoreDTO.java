package game.tetris;

import java.util.Date;

public class ScoreDTO {
  private int scoreNo;
  private int score;
  private String nickName;
  private Date time;
  private String imgURL;

  public ScoreDTO() {}

  public ScoreDTO(int scoreNo, int score, String nickName, Date time, String imgURL) {
    this.scoreNo = scoreNo;
    this.score = score;
    this.nickName = nickName;
    this.time = time;
    this.imgURL = imgURL;
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

  public final String getImgURL() {
    return imgURL;
  }

  public final void setImgURL(String imgURL) {
    this.imgURL = imgURL;
  }

  @Override
  public String toString() {
    return "ScoreDTO [scoreNo=" + scoreNo + ", score=" + score + ", nickName=" + nickName
        + ", time=" + time + ", imgURL=" + imgURL + "]";
  }
}

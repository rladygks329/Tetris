package edu.java.collections04;

public class Score {
  private int math;
  private int eng;

  public Score(int math, int eng) {
    this.math = math;
    this.eng = eng;
  }

  public Score() {}

  public void setMath(int math) {
    this.math = math;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public int getEng() {
    return eng;
  }

  @Override
  public String toString() {
    return "Score [math=" + math + ", eng=" + eng + "]";
  }

}

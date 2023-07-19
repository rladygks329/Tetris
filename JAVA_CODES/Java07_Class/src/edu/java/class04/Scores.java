package edu.java.class04;

public class Scores {
  int kor;
  int eng;
  int math;

  public Scores() {

  }

  public Scores(int kor, int eng, int math) {
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  public double getAvg() {
    return (double) (kor + eng + math) / 3;
  }

  public int getSum() {
    return kor + eng + math;
  }

  @Override
  public String toString() {
    return "국어점수 : " + kor + "\n영어점수 : " + eng + "\n수학점수 : " + math + "\n총점 : " + getSum()
        + "\n평균 : " + getAvg() + "\n";
  }

}

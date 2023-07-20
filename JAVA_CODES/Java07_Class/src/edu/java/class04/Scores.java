package edu.java.class04;

public class Scores {
  // 멤버 변수(필드, 프로퍼티)
  int kor; // 국어 점수
  int eng; // 영어 점수
  int math; // 수학 점수

  public Scores() {}

  public Scores(int kor, int eng, int math) {
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  // 세과목의 평균을 리턴하느 메소드
  public double calcAverage() {
    return (double) calcTotal() / 3;
  } // calcAverage()

  // 세 과목의 총합을 리턴하는 메소드
  public int calcTotal() {
    return kor + eng + math;
  } // end calcTotal()

  @Override
  public String toString() {
    return "국어점수 : " + kor + "\n영어점수 : " + eng + "\n수학점수 : " + math + "\n총점 : " + calcTotal()
        + "\n평균 : " + calcAverage() + "\n";
  } // end toString()

  public void printScores() {
    System.out.println("국어 : " + kor);
    System.out.println("영어 : " + eng);
    System.out.println("수학 : " + math);

  } // end printScores()

} // end Scores

package edu.java.class04;

public class ClassMain04 {

  public static void main(String[] args) {
    // Scores 클래스의 인스턴스 생성
    Scores scores1 = new Scores(10, 20, 30);

    // scores1의 모든 점수 출력
    scores1.printScores();

    // printAvg 메소드로 지나치게 추상화할 경우, 값을 가져와야할 때 다시 작업을 해야한다.
    // 상황에 맞는 설계를 하고, 필요한 작업을 잘 추상화하는게 중요하다.
    System.out.println("평균: " + scores1.calcAverage());

    Student james = new Student(10, "james", scores1);
    james.printStudentInfo();
    // System.out.println(james.toString());

    // james의 평균만 출력
    System.out.println(james.scores.calcAverage());

    Student stu2 = new Student(2, "둘리", new Scores(10, 20, 30));

    // 둘리의 총점 출력
    System.out.println("총점 : " + stu2.scores.calcTotal());
    stu2.printStudentInfo();

  } // end main()

} // end ClassMain04

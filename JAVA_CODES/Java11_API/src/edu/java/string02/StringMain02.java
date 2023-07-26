package edu.java.string02;

class Point {
  int x;
  int y;

  public Point() {}

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Point) {
      Point other = (Point) obj; // 강제 형변환
      return x == other.x && y == other.y;
    }

    return false;
  }

  @Override
  public String toString() {
    return "(" + x + " , " + y + ")";
  }
}


public class StringMain02 {

  public static void main(String[] args) {
    Point pt1 = new Point(1, 2);
    System.out.println(pt1);

    Point pt2 = new Point(1, 2);
    System.out.println(pt1);

    if (pt1 == pt2) {
      System.out.println("같은 참조");
    } else {
      System.out.println("다른 참조");
    }

    if (pt1.equals(pt2)) {
      System.out.println("같은 좌표");
    } else {
      System.out.println("다른 좌표");
    }
  }// end Main()

}// end String Main02

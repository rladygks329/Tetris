package game.tetris;

public class Point {
  public int x;
  public int y;

  public Point() {}

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Point) {
      Point opponent = ((Point) obj);
      return x == opponent.x && y == opponent.y;
    }
    return false;
  }

  @Override
  public String toString() {
    return "[POINT x: " + x + "y : " + y + "]";
  }
}

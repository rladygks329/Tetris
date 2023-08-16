package game.tetris;

abstract class Tetromino {
  protected Point center;
  public final Point[] points = new Point[4];

  protected Tetromino() {}

  public abstract void rotateLeft();

  public abstract void rotateRight();

  public void down() {
    for (Point point : points) {
      point.setPoint(point.x, point.y + 1);
    }
  }

  public void up() {
    for (Point point : points) {
      point.setPoint(point.x, point.y - 1);
    }
  }

  public void left() {
    for (Point point : points) {
      point.setPoint(point.x - 1, point.y);
    }
  }

  public void right() {
    for (Point point : points) {
      point.setPoint(point.x + 1, point.y);
    }
  }
}

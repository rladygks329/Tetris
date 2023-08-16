package game.tetris;

abstract class Tetromino {
  public final Point[] points = new Point[4];
  protected Point center;
  public int color;
  protected int length;
  protected int index;
  // based on - project/tetris_rotation_Nintendo.png
  protected int[][][] map;

  public void down() {
    for (Point point : points) {
      point.setPoint(point.x, point.y + 1);
    }
  } // end down()

  public void up() {
    for (Point point : points) {
      point.setPoint(point.x, point.y - 1);
    }
  }// end up()

  public void left() {
    for (Point point : points) {
      point.setPoint(point.x - 1, point.y);
    }
  }// end left()

  public void right() {
    for (Point point : points) {
      point.setPoint(point.x + 1, point.y);
    }
  }// end right()

  public void rotateLeft() {
    index = (length + index - 1) % length;
    update();
  }// end rotateLeft()

  public void rotateRight() {
    index = (index + 1) % length;
    update();
  }// end rotateRight()

  private void update() {
    int x = center.x;
    int y = center.y;

    for (int i = 0; i < points.length; i++) {
      points[i].setPoint(x + map[index][i][0], y + map[index][i][1]);
    }
  }// end update()
}// end Tetromino()

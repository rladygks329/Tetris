package game.tetris;

abstract class Tetromino {
  public static final int JTETROMINO_COLOR_CODE = 1;
  public static final int STETROMINO_COLOR_CODE = 2;
  public static final int ITETROMINO_COLOR_CODE = 3;
  public static final int LTETROMINO_COLOR_CODE = 4;
  public static final int TTETROMINO_COLOR_CODE = 5;
  public static final int ZTETROMINO_COLOR_CODE = 6;
  public static final int OTETROMINO_COLOR_CODE = 7;

  public final Point[] points = new Point[4];
  public int colorCode;
  protected Point center;
  protected int length;
  protected int index;
  // based on - project/tetris_rotation_Nintendo.png
  // spawan location reference - https://tetris.fandom.com/wiki/Spawn_Location
  protected int[][][] map;

  public void down() {
    for (Point point : points) {
      point.setPoint(point.x, point.y - 1);
    }
  } // end down()

  public void up() {
    for (Point point : points) {
      point.setPoint(point.x, point.y + 1);
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

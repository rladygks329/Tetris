package game.tetris;

public class ITetromino extends Tetromino {
  private int length = 2;
  private int index = 1;

  private int[][][] map = {//
      {//
          {-2, 0}, {-1, 0}, {0, 0}, {1, 0}}, //
      {//
          {0, -2}, {0, -1}, {0, 0}, {0, 1}//
      }//
  };

  public ITetromino(int x, int y) {
    // point //
    // point //
    // center//
    // point //

    points[0] = new Point(x, y);
    points[1] = new Point(x, y + 1);
    points[2] = new Point(x, y + 2);
    points[3] = new Point(x, y + 3);
  }

  @Override
  public void rotateLeft() {
    index = (length + index - 1) % length;
    update();
  }

  @Override
  public void rotateRight() {
    index = (index + 1) % length;
    update();

  }

  private void update() {
    int x = points[2].x;
    int y = points[2].y;

    for (int i = 0; i < points.length; i++) {
      points[i].setPoint(x + map[index][i][0], y + map[index][i][1]);
    }
  }

}// end ITetromino

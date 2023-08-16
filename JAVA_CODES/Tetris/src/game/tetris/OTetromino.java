package game.tetris;

public class OTetromino extends Tetromino {

  public OTetromino(int x, int y) {
    points[0] = new Point(x, y);
    points[1] = new Point(x, y - 1);
    points[2] = new Point(x + 1, y);
    points[3] = new Point(x + 1, y - 1);
  }

  @Override
  public void rotateLeft() {
    return;
  }

  @Override
  public void rotateRight() {
    return;
  }

}

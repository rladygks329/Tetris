package game.tetris;

public class ITetromino extends Tetromino {
  public ITetromino(int x, int y) {
    points[0] = new Point(x - 2, y + 1);
    points[1] = new Point(x - 1, y + 1);
    points[2] = new Point(x, y + 1);
    points[3] = new Point(x + 1, y + 1);

    // init
    map = new int[][][] {{{-2, 0}, {-1, 0}, {0, 0}, {1, 0}}, {{0, -2}, {0, -1}, {0, 0}, {0, 1}}};
    length = map.length;
    index = 0;
    center = points[2];
    color = 3;
  }

}// end ITetromino

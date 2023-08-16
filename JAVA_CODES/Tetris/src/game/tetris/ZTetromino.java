package game.tetris;

public class ZTetromino extends Tetromino {
  public ZTetromino(int x, int y) {
    points[0] = new Point(x - 2, y);
    points[1] = new Point(x - 1, y); // center
    points[2] = new Point(x - 1, y + 1);
    points[3] = new Point(x, y + 1);

    // init
    map = new int[][][] {//
        {{-1, 0}, {0, 0}, {0, 1}, {1, 1}}, //
        {{0, 1}, {0, 0}, {1, 0}, {1, -1}}, //
    };
    length = map.length;
    index = 0;
    center = points[1];
  }
}

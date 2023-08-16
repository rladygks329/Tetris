package game.tetris;

public class LTetromino extends Tetromino {
  public LTetromino(int x, int y) {
    points[0] = new Point(x, y);
    points[1] = new Point(x, y + 1); // center
    points[2] = new Point(x, y + 2);
    points[3] = new Point(x + 1, y + 2);

    // init
    map = new int[][][] {//
        {{1, 0}, {0, 0}, {-1, 0}, {-1, 1}}, //
        {{0, 1}, {0, 0}, {0, -1}, {-1, -1}}, //
        {{-1, 0}, {0, 0}, {1, 0}, {1, -1}}, //
        {{0, -1}, {0, 0}, {0, 1}, {1, 1}} //
    };
    length = map.length;
    index = 3;
    center = points[1];
  }
} // end LTetromino

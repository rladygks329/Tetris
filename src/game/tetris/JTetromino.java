package game.tetris;

public class JTetromino extends Tetromino {
  public JTetromino(int x, int y) {
    points[0] = new Point(x - 2, y);
    points[1] = new Point(x - 2, y - 1);
    points[2] = new Point(x - 1, y - 1); // center
    points[3] = new Point(x, y - 1);

    // init
    map = new int[][][] {//
        {{1, -1}, {1, 0}, {0, 0}, {-1, 0}}, //
        {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, //
        {{-1, 1}, {-1, 0}, {0, 0}, {1, 0}}, //
        {{1, 1}, {0, 1}, {0, 0}, {0, -1}} //
    };
    length = map.length;
    index = 2;
    center = points[2];
    colorCode = JTETROMINO_COLOR_CODE;
  }
}// end JTetromino

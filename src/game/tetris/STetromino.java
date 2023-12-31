package game.tetris;

public class STetromino extends Tetromino {
  public STetromino(int x, int y) {
    points[0] = new Point(x, y);
    points[1] = new Point(x - 1, y); // center
    points[2] = new Point(x - 1, y - 1);
    points[3] = new Point(x - 2, y - 1);

    // init
    map = new int[][][] {//
        {{1, 0}, {0, 0}, {0, -1}, {-1, -1}}, //
        {{0, 1}, {0, 0}, {1, 0}, {1, -1}}, //
    };
    length = map.length;
    index = 0;
    center = points[1];
    colorCode = STETROMINO_COLOR_CODE;
  }

}

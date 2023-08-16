package game.tetris;

import java.util.Arrays;

public class Board {
  public static final int WIDTH = 10;
  public static final int HEIGHT = 20;
  public int[][] map;

  public Board() {
    map = new int[HEIGHT][WIDTH];
  }

  public void mark(Point p, int value) {
    int x = p.x;
    int y = p.y;
    if (y < 0) {
      return;
    }
    map[y][x] = value;
  }

  public boolean isValid(Point p) {
    if (p.x < 0 || p.x >= WIDTH || p.y >= HEIGHT) {
      return false;
    }

    // 아직 화면에 나오지 않은 좌표이므로 검사할 필요가 없다.
    if (p.y < 0) {
      return true;
    }
    return map[p.y][p.x] == 0;
  }

  public int hanldeClear() {
    int line = 0;

    for (int i = 0; i < Board.HEIGHT; i++) {
      boolean isFull = isLineFull(i);
      if (isFull) {
        line += 1;
        pullLine(i);
      }
    }
    return line;
  }

  // 맵에서 해당 라인이 채워져있는지 검사하는 함수
  private boolean isLineFull(int height) {
    boolean result = true;
    for (int i = 0; i < Board.WIDTH; i++) {
      if (map[height][i] == 0) {
        result = false;
        break;
      }
    }
    return result;
  }// end isLineFull()

  private void pullLine(int height) {
    for (int i = height; i > 0; i--) {
      map[i] = Arrays.copyOf(map[i - 1], WIDTH);
    }

    for (int i = 0; i < WIDTH; i++) {
      map[0][i] = 0;
    }
  }// end pullLine()

}

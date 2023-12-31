package game.tetris;

import java.util.Arrays;

public class Board {
  public static final int EMPTY = 0;
  public static final int SHADOW = 8;
  public static final int WIDTH = 10;
  public static final int HEIGHT = 20;
  public int[][] map;

  public Board() {
    map = new int[HEIGHT + 2][WIDTH];
  }

  public void mark(Point p, int value) {
    int x = p.x;
    int y = p.y;
    map[y][x] = value;
  }

  public void clear() {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = 0;
      }
    }
  }

  public boolean isValid(Point p) {
    if (p.x < 0 || p.x >= WIDTH || p.y < 0 || p.y >= HEIGHT + 2) {
      return false;
    }
    return map[p.y][p.x] == EMPTY || map[p.y][p.x] == SHADOW;
  }

  public int hanldeClear() {
    int line = 0;

    for (int i = Board.HEIGHT; i >= 0; i--) {
      if (isLineFull(i)) {
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
      if (map[height][i] == Board.EMPTY) {
        result = false;
        break;
      }
    }
    return result;
  }// end isLineFull()

  // 라인이 지워졌을 때 map을 한칸씩 앞으로 당기는 함수
  private void pullLine(int height) {
    for (int i = height; i < Board.HEIGHT + 1; i++) {
      map[i] = Arrays.copyOf(map[i + 1], WIDTH);
    }
    // 맨 위에 칸 초기화
    for (int i = 0; i < WIDTH; i++) {
      map[Board.HEIGHT + 1][i] = Board.EMPTY;
    }
  }// end pullLine()

}

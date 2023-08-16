package game.tetris;

public class Tetris {
  public int gameState; // pause, normal, over,
  public int score;
  private Tetromino tetromino;
  public Board board;

  public Tetris() {
    this.board = new Board();
    tetromino = tmpFactory();
    markOn(tetromino);
  }

  public void down() {
    markOff(tetromino);
    tetromino.down();

    if (isValid(tetromino)) {
      markOn(tetromino);
      score += 100;
    } else {
      tetromino.up();
      markOn(tetromino);
      hanldeClear();
      tetromino = tmpFactory();
    }

  }

  public void left() {
    markOff(tetromino);
    tetromino.left();
    if (!isValid(tetromino)) {
      tetromino.right();
    }
    markOn(tetromino);
  }

  public void right() {
    markOff(tetromino);
    tetromino.right();
    if (!isValid(tetromino)) {
      tetromino.left();
    }
    markOn(tetromino);
  }

  public void rotateLeft() {
    markOff(tetromino);
    tetromino.rotateLeft();
    if (!isValid(tetromino)) {
      tetromino.rotateRight();
    }
    markOn(tetromino);
  }

  public void rotateRight() {
    markOff(tetromino);
    tetromino.rotateRight();
    if (!isValid(tetromino)) {
      tetromino.rotateLeft();
    }
    markOn(tetromino);
  }

  private void hanldeClear() {
    int[][] map = board.map;
    int line = 0;

    for (int i = 0; i < Board.HEIGHT; i++) {
      boolean isFull = true;

      // 가로 라인 검사
      for (int j = 0; j < Board.WIDTH; j++) {
        if (map[i][j] == 0) {
          isFull = false;
          break;
        }
      }

      if (!isFull) {
        continue;
      }

      // 가로 라인 지우기
      line += 1;
      for (int j = 0; j < Board.WIDTH; j++) {
        map[i][j] = 0;
      }
    }
    score += line * 1000;
  }

  private void reStrat() {}

  private boolean isValid(Tetromino t) {
    for (Point p : t.points) {
      if (!board.isValid(p)) {
        return false;
      }
    }
    return true;
  }

  // board에 tetromino를 표시한다.
  private void markOn(Tetromino t) {
    for (Point p : t.points) {
      board.mark(p, 1);
    }
  } // end markOn()

  // board에 tetromino를 제거한다.
  private void markOff(Tetromino t) {
    for (Point p : t.points) {
      board.mark(p, 0);
    }
  } // end markOff()

  private Tetromino tmpFactory() {
    return new ITetromino(5, 1);
  }
}

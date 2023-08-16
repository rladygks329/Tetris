package game.tetris;

public class Tetris {
  public int state; // pause, normal, over,
  public int score;
  private Tetromino tetromino;
  private TetrominoFactory tetrominoFactory;
  public Board board;

  public Tetris() {
    board = new Board();
    tetrominoFactory = new TetrominoFactory(5, 0);
    tetromino = tetrominoFactory.get();
    markOn(tetromino);
  }

  public void down() {
    if (state == -1) {
      return;
    }
    markOff(tetromino);
    tetromino.down();

    if (isValid(tetromino)) {
      markOn(tetromino);
      score += 100;
    } else {
      tetromino.up();
      markOn(tetromino);
      board.hanldeClear();
      tetromino = tetrominoFactory.get();
      if (!isValid(tetromino)) {
        state = -1;
      }
    }
  }

  public void left() {
    if (state == -1) {
      return;
    }
    markOff(tetromino);
    tetromino.left();
    if (!isValid(tetromino)) {
      tetromino.right();
    }
    markOn(tetromino);
  }

  public void right() {
    if (state == -1) {
      return;
    }
    markOff(tetromino);
    tetromino.right();
    if (!isValid(tetromino)) {
      tetromino.left();
    }
    markOn(tetromino);
  }

  public void rotateLeft() {
    if (state == -1) {
      return;
    }
    markOff(tetromino);
    tetromino.rotateLeft();
    if (!isValid(tetromino)) {
      tetromino.rotateRight();
    }
    markOn(tetromino);
  }

  public void rotateRight() {
    if (state == -1) {
      return;
    }
    markOff(tetromino);
    tetromino.rotateRight();
    if (!isValid(tetromino)) {
      tetromino.rotateLeft();
    }
    markOn(tetromino);
  }

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
      board.mark(p, t.color);
    }
  } // end markOn()

  // board에 tetromino를 제거한다.
  private void markOff(Tetromino t) {
    for (Point p : t.points) {
      board.mark(p, 0);
    }
  } // end markOff()
}

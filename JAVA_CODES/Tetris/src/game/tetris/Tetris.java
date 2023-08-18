package game.tetris;

public class Tetris {
  public int state; // pause, normal, over,
  public int score;
  private Tetromino tetromino;
  private TetrominoFactory tetrominoFactory;
  private Point[] shadows;
  public int savedTetrominoCode = 0;
  public Board board;

  public Tetris() {
    board = new Board();
    shadows = new Point[4];
    for (int i = 0; i < 4; i++) {
      shadows[i] = new Point();
    }
    tetrominoFactory = new TetrominoFactory(5, 0);
    tetromino = tetrominoFactory.get();

    tetromino.points.clone();
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
      board.hanldeClear();
      tetromino = tetrominoFactory.get();
      if (!isValid(tetromino)) {
        state = -1;
        return;
      }
      markOn(tetromino);
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

  public void hardDrop() {
    markOff(tetromino);
    int count = -1;
    while (isValid(tetromino)) {
      tetromino.down();
      count += 1;
    }
    score += count * 100;
    tetromino.up();
    markOn(tetromino);
    board.hanldeClear();
    tetromino = tetrominoFactory.get();
    if (!isValid(tetromino)) {
      state = -1;
      return;
    }
    markOn(tetromino);
  }

  public void restart() {
    state = 0;
    score = 0;
    savedTetrominoCode = 0;
    board.clear();
    tetrominoFactory.init();
    tetromino = tetrominoFactory.get();
    markOn(tetromino);
  }

  public int getNextBlock() {
    return tetrominoFactory.next().color;
  }

  private boolean isValid(Tetromino t) {
    for (Point p : t.points) {
      if (!board.isValid(p)) {
        return false;
      }
    }
    return true;
  }

  private void updateShadow() {
    // 내려간 위치 구하기
    int count = 0;
    while (isValid(tetromino)) {
      count += 1;
      tetromino.down();
    }
    count--;
    tetromino.up();

    // shadow 배열에 넣기
    for (int i = 0; i < 4; i++) {
      Point p = tetromino.points[i];
      shadows[i].setPoint(p.x, p.y);
    }

    // 다시 되돌리기
    while (count > 0) {
      tetromino.up();
      count -= 1;
    }
  }

  public void switchBlock() {
    // 무한히 사용하는 것을 방지
    if (score >= 3000) {
      score -= 3000;
    }

    // 저장된게 없을 때, 저장만 하기
    if (savedTetrominoCode == 0) {
      savedTetrominoCode = tetromino.color;
      markOff(tetromino);
      tetromino = tetrominoFactory.get();
      if (!isValid(tetromino)) {
        state = -1;
        return;
      }
      markOn(tetromino);
      return;
    }

    // 지우고 새로 가져와서 칠한다.
    int curCode = tetromino.color;
    markOff(tetromino);
    tetromino = tetrominoFactory.getTetrominoByCode(savedTetrominoCode);
    if (!isValid(tetromino)) {
      state = -1;
      return;
    }
    markOn(tetromino);
    savedTetrominoCode = curCode;
  }

  // board에 tetromino를 표시한다.
  private void markOn(Tetromino t) {
    updateShadow();
    for (Point p : shadows) {
      board.mark(p, Board.SHADOW);
    }
    for (Point p : t.points) {
      board.mark(p, t.color);
    }
  } // end markOn()

  // board에 tetromino를 제거한다.
  private void markOff(Tetromino t) {
    for (Point p : shadows) {
      board.mark(p, Board.EMPTY);
    }

    for (Point p : t.points) {
      board.mark(p, Board.EMPTY);
    }
  } // end markOff()
}

package game.tetris;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Tetris {
  public static final int GAME_OVER = -2;
  public static final int GAME_PAUSE = -1;
  public static final int GAME_NORMAL = 0;

  private static final int BASIC_BLOCK_POINT_X = 5;
  private static final int BASIC_BLOCK_POINT_y = 20;

  private TetrominoFactory tetrominoFactory;
  private Tetromino tetromino;
  private Point[] shadows;
  private Date startDate;

  private boolean isSwitchable;
  public Board board;
  public int state;
  public int score;
  public int nextTetrominoCode = 0;
  public int savedTetrominoCode = 0;

  public Tetris() {
    board = new Board();
    shadows = new Point[4];
    startDate = new Date();
    for (int i = 0; i < 4; i++) {
      shadows[i] = new Point();
    }
    tetrominoFactory = new TetrominoFactory(BASIC_BLOCK_POINT_X, BASIC_BLOCK_POINT_y);
    tetromino = tetrominoFactory.get();
    isSwitchable = true;
    nextTetrominoCode = getNextBlockColorCode();
    markOn(tetromino);
  }

  public void down() {
    markOff(tetromino);
    tetromino.down();

    if (isValid(tetromino)) {
      markOn(tetromino);
      score += 100;
      return;
    }

    // 벽 또는 블록과 충돌 발생
    tetromino.up();
    markOn(tetromino);
    int clearedLine = board.hanldeClear();
    score += clearedLine * 1000;

    // 새로운 블록을 가져온다.
    tetromino = tetrominoFactory.get();
    isSwitchable = true;
    nextTetrominoCode = getNextBlockColorCode();
    if (!isValid(tetromino)) {
      state = GAME_OVER;
      return;
    }
    markOn(tetromino);
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
    down();
  }

  public void switchBlock() {
    if (!isSwitchable) {
      return;
    }

    isSwitchable = false;
    markOff(tetromino);
    int curCode = tetromino.colorCode;
    tetromino = tetrominoFactory.getTetrominoByCode(savedTetrominoCode);
    nextTetrominoCode = getNextBlockColorCode();
    savedTetrominoCode = curCode;
    if (!isValid(tetromino)) {
      state = GAME_OVER;
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
    isSwitchable = true;
    nextTetrominoCode = getNextBlockColorCode();
    markOn(tetromino);
  }

  private int getNextBlockColorCode() {
    return tetrominoFactory.next().colorCode;
  }

  private boolean isValid(Tetromino t) {
    return Arrays.stream(t.points).allMatch(p -> board.isValid(p));
  }

  public String getPlayTime() {
    Calendar c = Calendar.getInstance();
    c.setTime(startDate);
    Long start = c.getTimeInMillis();
    c.setTime(new Date());
    Long cur = c.getTimeInMillis();

    return "PlayTime : " + (cur - start) / 1000 + " seconds";
  } // end getPlayTime()


  private void updateShadow() {
    // 내려간 위치 구하기
    int count = -1;
    while (isValid(tetromino)) {
      count += 1;
      tetromino.down();
    }
    tetromino.up();

    // shadow 위치 설정하기
    for (int i = 0; i < 4; i++) {
      Point p = tetromino.points[i];
      shadows[i].setPoint(p.x, p.y);
    }

    // 블록 되돌리기
    while (count > 0) {
      tetromino.up();
      count -= 1;
    }
  } // end UpdateShadow()

  // board에 tetromino를 표시한다.
  private void markOn(Tetromino t) {
    updateShadow();
    for (Point p : shadows) {
      board.mark(p, Board.SHADOW);
    }

    for (Point p : t.points) {
      board.mark(p, t.colorCode);
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

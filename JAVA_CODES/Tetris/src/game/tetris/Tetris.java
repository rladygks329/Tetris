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
    } else {
      tetromino.up();
      markOn(tetromino);
      tetromino = tmpFactory();
    }
  }

  public void handleUserInput(int userInput) {}

  private void hanldeClear() {}

  private void reStrat() {}

  private boolean isValid(Tetromino t) {
    for (Point p : t.points) {
      if (!board.isValid(p)) {
        return false;
      }
    }
    return true;
  }

  private void markOn(Tetromino t) {
    for (Point p : t.points) {
      board.mark(p, 1);
    }
  }

  private void markOff(Tetromino t) {
    for (Point p : t.points) {
      board.mark(p, 0);
    }
  }

  private OTetromino tmpFactory() {
    return new OTetromino(5, 1);
  }

}

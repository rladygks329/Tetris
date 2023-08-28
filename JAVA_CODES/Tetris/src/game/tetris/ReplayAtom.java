package game.tetris;

import java.io.Serializable;
import java.util.Arrays;

public class ReplayAtom implements Serializable {
  int[][] map;
  int score;
  int nextBlockCode;
  int savedBlockCode;
  int delay;

  public ReplayAtom(Tetris tetris, int delay) {
    this.map = new int[Board.HEIGHT + 2][Board.WIDTH];
    this.score = tetris.score;
    this.nextBlockCode = tetris.nextTetrominoCode;
    this.savedBlockCode = tetris.savedTetrominoCode;
    this.delay = delay;

    int[][] board = tetris.board.map;
    for (int i = 0; i < Board.HEIGHT + 2; i++) {
      map[i] = Arrays.copyOf(board[i], Board.WIDTH);
    }
  }
}

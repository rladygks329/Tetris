package game.tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrominoFactory {
  private List<Tetromino> tetrominoList;
  private int index;
  private int x;
  private int y;

  public TetrominoFactory(int x, int y) {
    this.x = x;
    this.y = y;
    index = 0;
    createTetromino();
  }

  public Tetromino get() {
    if (index == tetrominoList.size()) {
      index = 0;
      createTetromino();
    }
    return tetrominoList.get(index++);
  }

  public void createTetromino() {
    tetrominoList = new ArrayList<>();
    tetrominoList.add(new ITetromino(x, y));
    tetrominoList.add(new OTetromino(x, y));
    tetrominoList.add(new STetromino(x, y));
    tetrominoList.add(new ZTetromino(x, y));
    tetrominoList.add(new LTetromino(x, y));
    tetrominoList.add(new JTetromino(x, y));
    tetrominoList.add(new TTetromino(x, y));
    Collections.shuffle(tetrominoList);
  }
}

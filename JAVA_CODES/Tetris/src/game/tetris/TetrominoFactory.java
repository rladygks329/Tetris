package game.tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrominoFactory {
  private List<Tetromino> tetrominoList;
  private List<Tetromino> nextTetrominoList;

  private int index;
  private int x;
  private int y;

  public TetrominoFactory(int x, int y) {
    this.x = x;
    this.y = y;
    init();
  }

  public Tetromino get() {
    if (index == tetrominoList.size()) {
      index = 0;
      tetrominoList = nextTetrominoList;
      createNextTetromino();
    }
    return tetrominoList.get(index++);
  }

  public Tetromino next() {
    int next = index;
    if (next == tetrominoList.size()) {
      return nextTetrominoList.get(0);
    }
    return tetrominoList.get(next);
  }

  public Tetromino getTetrominoByCode(int code) {
    Tetromino result = null;
    switch (code) {
      case 1:
        result = new JTetromino(x, y);
        break;
      case 2:
        result = new STetromino(x, y);
        break;
      case 3:
        result = new ITetromino(x, y);
        break;
      case 4:
        result = new LTetromino(x, y);
        break;
      case 5:
        result = new TTetromino(x, y);
        break;
      case 6:
        result = new ZTetromino(x, y);
        break;
      case 7:
        result = new OTetromino(x, y);
        break;
      default:
        result = get();
        break;
    }
    return result;
  }

  public void init() {
    index = 0;
    tetrominoList = new ArrayList<>();
    tetrominoList.add(new ITetromino(x, y));
    tetrominoList.add(new OTetromino(x, y));
    tetrominoList.add(new STetromino(x, y));
    tetrominoList.add(new ZTetromino(x, y));
    tetrominoList.add(new LTetromino(x, y));
    tetrominoList.add(new JTetromino(x, y));
    tetrominoList.add(new TTetromino(x, y));
    Collections.shuffle(tetrominoList);

    nextTetrominoList = new ArrayList<>();
    nextTetrominoList.add(new ITetromino(x, y));
    nextTetrominoList.add(new OTetromino(x, y));
    nextTetrominoList.add(new STetromino(x, y));
    nextTetrominoList.add(new ZTetromino(x, y));
    nextTetrominoList.add(new LTetromino(x, y));
    nextTetrominoList.add(new JTetromino(x, y));
    nextTetrominoList.add(new TTetromino(x, y));
    Collections.shuffle(nextTetrominoList);
  }

  private void createNextTetromino() {
    nextTetrominoList = new ArrayList<>();
    nextTetrominoList.add(new ITetromino(x, y));
    nextTetrominoList.add(new OTetromino(x, y));
    nextTetrominoList.add(new STetromino(x, y));
    nextTetrominoList.add(new ZTetromino(x, y));
    nextTetrominoList.add(new LTetromino(x, y));
    nextTetrominoList.add(new JTetromino(x, y));
    nextTetrominoList.add(new TTetromino(x, y));
    Collections.shuffle(nextTetrominoList);
  }
}

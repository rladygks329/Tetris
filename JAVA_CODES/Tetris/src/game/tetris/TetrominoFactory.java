package game.tetris;

import static game.tetris.Tetromino.ITETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.JTETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.LTETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.OTETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.STETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.TTETROMINO_COLOR_CODE;
import static game.tetris.Tetromino.ZTETROMINO_COLOR_CODE;
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
      case JTETROMINO_COLOR_CODE:
        result = new JTetromino(x, y);
        break;
      case STETROMINO_COLOR_CODE:
        result = new STetromino(x, y);
        break;
      case ITETROMINO_COLOR_CODE:
        result = new ITetromino(x, y);
        break;
      case LTETROMINO_COLOR_CODE:
        result = new LTetromino(x, y);
        break;
      case TTETROMINO_COLOR_CODE:
        result = new TTetromino(x, y);
        break;
      case ZTETROMINO_COLOR_CODE:
        result = new ZTetromino(x, y);
        break;
      case OTETROMINO_COLOR_CODE:
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

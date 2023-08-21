package game.tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisKeyListener implements KeyListener {
  public static int KEY_CODE_LEFT = 37;
  public static int KEY_CODE_RIGHT = 39;
  public static int KEY_CODE_DOWN = 40;
  public static int KEY_CODE_ROTATE_LEFT = 90;
  public static int KEY_CODE_ROTATE_RIGHT = 88;
  public static int KEY_CODE_HARD_DROP = 32;
  public static int KEY_CODE_SWITCH = 67;
  public static int KEY_CODE_ESC = 27;
  Tetris tetris;
  TetrisView tetrisView;

  public TetrisKeyListener(Tetris tetris, TetrisView tetrisView) {
    this.tetris = tetris;
    this.tetrisView = tetrisView;
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {

    if (e.getKeyCode() == KEY_CODE_ESC) {
      tetrisView.toggleGamePause();
      tetrisView.repaint();
      return;
    }

    if (tetris.state == Tetris.GAME_OVER || tetrisView.gamePause) {
      return;
    }

    if (e.getKeyCode() == KEY_CODE_LEFT) {
      tetris.left();
    } else if (e.getKeyCode() == KEY_CODE_RIGHT) {
      tetris.right();
    } else if (e.getKeyCode() == KEY_CODE_DOWN) {
      tetris.down();
    } else if (e.getKeyCode() == KEY_CODE_ROTATE_LEFT) {
      tetris.rotateLeft();
    } else if (e.getKeyCode() == KEY_CODE_ROTATE_RIGHT) {
      tetris.rotateRight();
    } else if (e.getKeyCode() == KEY_CODE_HARD_DROP) {
      tetris.hardDrop();
    } else if (e.getKeyCode() == KEY_CODE_SWITCH) {
      tetris.switchBlock();
    }

    tetrisView.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}
}

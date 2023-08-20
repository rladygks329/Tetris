package game.tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class TetrisKeyListener implements KeyListener {
  private final int KEY_CODE_LEFT = 37;
  private final int KEY_CODE_RIGHT = 39;
  private final int KEY_CODE_DOWN = 40;
  private final int KEY_CODE_ROTATE_LEFT = 90;
  private final int KEY_CODE_ROTATE_RIGHT = 88;
  private final int KEY_CODE_HARD_DROP = 32;
  private final int KEY_CODE_SWITCH = 67;
  Tetris tetris;
  JPanel panel;

  public TetrisKeyListener(Tetris tetris, JPanel panel) {
    this.tetris = tetris;
    this.panel = panel;
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    if (tetris.state == -1) {
      return;
    }

    switch (e.getKeyCode()) {
      case KEY_CODE_LEFT:
        tetris.left();
        break;
      case KEY_CODE_RIGHT:
        tetris.right();
        break;
      case KEY_CODE_DOWN:
        tetris.down();
        break;
      case KEY_CODE_ROTATE_LEFT:
        tetris.rotateLeft();
        break;
      case KEY_CODE_ROTATE_RIGHT:
        tetris.rotateRight();
        break;
      case KEY_CODE_HARD_DROP:
        tetris.hardDrop();
        break;
      case KEY_CODE_SWITCH:
        tetris.switchBlock();
        break;
      default:
        break;
    }
    panel.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}
}

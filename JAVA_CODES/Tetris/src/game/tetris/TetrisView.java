package game.tetris;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisView extends JPanel {
  // constants
  private final String BACKGROUD_IMG_PATH =
      "res" + File.separator + "Tetriminos" + File.separator + "Board" + File.separator;
  private final String BLOCK_IMG_PATH =
      "res" + File.separator + "Tetriminos" + File.separator + "Single Blocks" + File.separator;
  private final int KEY_CODE_LEFT = 37;
  private final int KEY_CODE_RIGHT = 39;
  private final int KEY_CODE_DOWN = 40;
  private final int KEY_CODE_ROTATE_LEFT = 90;
  private final int KEY_CODE_ROTATE_RIGHT = 88;
  private final int KEY_CODE_HARDDROP = 32;
  private final int BOX_SIZE = 30;

  // member 변수
  private Tetris tetris;
  private Board board;
  private ActionListener gameLoop;
  private Timer timer;
  private Image bg;
  private Image[] blockImg;

  public TetrisView() {
    setLayout(new BorderLayout(0, 0));
    tetris = new Tetris();
    board = tetris.board;

    // init images
    bg = getBlockImg(BACKGROUD_IMG_PATH + "Board.png", 12 * BOX_SIZE, 22 * BOX_SIZE);
    blockImg = new Image[8];
    blockImg[0] = getBlockImg(BACKGROUD_IMG_PATH + "BG_1.png", BOX_SIZE, BOX_SIZE);
    blockImg[1] = getBlockImg(BLOCK_IMG_PATH + "Blue.png", BOX_SIZE, BOX_SIZE);
    blockImg[2] = getBlockImg(BLOCK_IMG_PATH + "Green.png", BOX_SIZE, BOX_SIZE);
    blockImg[3] = getBlockImg(BLOCK_IMG_PATH + "LightBlue.png", BOX_SIZE, BOX_SIZE);
    blockImg[4] = getBlockImg(BLOCK_IMG_PATH + "Orange.png", BOX_SIZE, BOX_SIZE);
    blockImg[5] = getBlockImg(BLOCK_IMG_PATH + "Purple.png", BOX_SIZE, BOX_SIZE);
    blockImg[6] = getBlockImg(BLOCK_IMG_PATH + "Red.png", BOX_SIZE, BOX_SIZE);
    blockImg[7] = getBlockImg(BLOCK_IMG_PATH + "Yellow.png", BOX_SIZE, BOX_SIZE);

    // init game loop(thread)
    gameLoop = actionEvent -> {
      tetris.down();
      repaint();
      if (tetris.state == -1) {
        timer.stop();
      }
    };

    timer = new Timer(500, gameLoop);
    timer.setInitialDelay(1000);
    timer.start();

    // init keyListener
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleUserInput(e.getKeyCode());
      }
    });
  }

  private void handleUserInput(int keyCode) {
    switch (keyCode) {
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
      case KEY_CODE_HARDDROP:
        tetris.hardDrop();
        break;
      default:
        break;
    }
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(bg, 0, 0, 12 * BOX_SIZE, 22 * BOX_SIZE, this);

    // 블록 생성을 위한 보이지않는 두 줄이 존재함
    for (int i = 2; i < Board.HEIGHT + 2; i++) {
      for (int j = 0; j < Board.WIDTH; j++) {
        int type = board.map[i][j];
        g.drawImage(blockImg[type], (j + 1) * BOX_SIZE, (i - 1) * BOX_SIZE, this);
      }
    }
  }// end paint()

  private Image getBlockImg(String imgPath, int width, int height) {
    return Toolkit.getDefaultToolkit().getImage(imgPath).getScaledInstance(width, height,
        java.awt.Image.SCALE_SMOOTH);
  }
} // end getBlockImg()

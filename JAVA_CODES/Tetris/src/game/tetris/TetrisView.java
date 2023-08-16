package game.tetris;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisView extends JPanel {
  private final String BACKGROUD_IMG_PATH = "res" + File.separator + "Tetriminos" + File.separator
      + "Board" + File.separator + "Board.png";
  private final String BLOCK_IMG_PATH =
      "res" + File.separator + "Tetriminos" + File.separator + "Single Blocks" + File.separator;
  private Tetris tetris;
  private Board board;
  private ActionListener gameLoop;
  private Timer timer;

  int boxSize = 30;

  private Image bg;
  private Image[] blockImg;

  public TetrisView() {

    tetris = new Tetris();
    board = tetris.board;

    // init images
    bg = getBlockImg(BACKGROUD_IMG_PATH, 12 * boxSize, 22 * boxSize);
    blockImg = new Image[7];
    blockImg[0] = getBlockImg(BLOCK_IMG_PATH + "Blue.png", boxSize, boxSize);
    blockImg[1] = getBlockImg(BLOCK_IMG_PATH + "Green.png", boxSize, boxSize);
    blockImg[2] = getBlockImg(BLOCK_IMG_PATH + "LightBlue.png", boxSize, boxSize);
    blockImg[3] = getBlockImg(BLOCK_IMG_PATH + "Orange.png", boxSize, boxSize);
    blockImg[4] = getBlockImg(BLOCK_IMG_PATH + "Purple.png", boxSize, boxSize);
    blockImg[5] = getBlockImg(BLOCK_IMG_PATH + "Red.png", boxSize, boxSize);
    blockImg[6] = getBlockImg(BLOCK_IMG_PATH + "Yellow.png", boxSize, boxSize);

    gameLoop = actionEvent -> {
      tetris.down();
      repaint();
    };
    timer = new Timer(500, gameLoop);
    timer.setInitialDelay(1000);
    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(bg, 0, 0, 12 * boxSize, 22 * boxSize, this);
    for (int i = 0; i < Board.HEIGHT; i++) {
      for (int j = 0; j < Board.WIDTH; j++) {
        int type = board.map[i][j];
        g.drawImage(blockImg[type], (j + 1) * boxSize, (i + 1) * boxSize, this);
      }
    }
  }// end paint()

  private Image getBlockImg(String imgPath, int width, int height) {
    return Toolkit.getDefaultToolkit().getImage(imgPath).getScaledInstance(width, height,
        java.awt.Image.SCALE_SMOOTH);
  }
} // end getBlockImg()

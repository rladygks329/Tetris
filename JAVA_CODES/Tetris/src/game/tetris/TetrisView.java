package game.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisView extends JPanel {
  // constants
  private final String BACKGROUD_IMG_PATH =
      "res" + File.separator + "Tetrominos" + File.separator + "Board" + File.separator;
  private final String BLOCK_IMG_PATH =
      "res" + File.separator + "Tetrominos" + File.separator + "Single Blocks" + File.separator;
  private final String SHAPE_IMG_PATH =
      "res" + File.separator + "Tetrominos" + File.separator + "Shape Blocks" + File.separator;
  private final int BOX_SIZE = 30;
  private final int SHAPE_SIZE = 120;

  private final int KEY_CODE_LEFT = 37;
  private final int KEY_CODE_RIGHT = 39;
  private final int KEY_CODE_DOWN = 40;
  private final int KEY_CODE_ROTATE_LEFT = 90;
  private final int KEY_CODE_ROTATE_RIGHT = 88;
  private final int KEY_CODE_HARDDROP = 32;

  // member 변수
  private Main main;
  private UserDTO user;
  private TetrisDAO dao;
  private Tetris tetris;
  private Board board;
  private ActionListener gameLoop;
  private Timer timer;
  private Image bg;
  private Image[] blockImg;
  private Image[] shapeImg;

  public TetrisView(Main main) {
    this.main = main;
    user = main.user;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setBounds(0, 0, 700, 699);
    setLayout(null);

    tetris = new Tetris();
    board = tetris.board;

    // init images
    bg = getResizeImg(BACKGROUD_IMG_PATH + "Board.png", 12 * BOX_SIZE, 22 * BOX_SIZE);
    blockImg = new Image[8];
    blockImg[0] = getResizeImg(BACKGROUD_IMG_PATH + "BG_1.png", BOX_SIZE, BOX_SIZE);
    blockImg[1] = getResizeImg(BLOCK_IMG_PATH + "Blue.png", BOX_SIZE, BOX_SIZE);
    blockImg[2] = getResizeImg(BLOCK_IMG_PATH + "Green.png", BOX_SIZE, BOX_SIZE);
    blockImg[3] = getResizeImg(BLOCK_IMG_PATH + "LightBlue.png", BOX_SIZE, BOX_SIZE);
    blockImg[4] = getResizeImg(BLOCK_IMG_PATH + "Orange.png", BOX_SIZE, BOX_SIZE);
    blockImg[5] = getResizeImg(BLOCK_IMG_PATH + "Purple.png", BOX_SIZE, BOX_SIZE);
    blockImg[6] = getResizeImg(BLOCK_IMG_PATH + "Red.png", BOX_SIZE, BOX_SIZE);
    blockImg[7] = getResizeImg(BLOCK_IMG_PATH + "Yellow.png", BOX_SIZE, BOX_SIZE);

    shapeImg = new Image[8];
    shapeImg[0] = getResizeImg(SHAPE_IMG_PATH + "I.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[1] = getResizeImg(SHAPE_IMG_PATH + "J.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[2] = getResizeImg(SHAPE_IMG_PATH + "S.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[3] = getResizeImg(SHAPE_IMG_PATH + "I.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[4] = getResizeImg(SHAPE_IMG_PATH + "L.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[5] = getResizeImg(SHAPE_IMG_PATH + "T.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[6] = getResizeImg(SHAPE_IMG_PATH + "Z.png", SHAPE_SIZE, SHAPE_SIZE);
    shapeImg[7] = getResizeImg(SHAPE_IMG_PATH + "O.png", SHAPE_SIZE, SHAPE_SIZE);

    // init game loop(thread)
    gameLoop = actionEvent -> {
      tetris.down();
      repaint();
      if (tetris.state == -1) {
        timer.stop();
        dao.insert(user.getNo(), tetris.score);
        int result = JOptionPane.showConfirmDialog(this,
            "게임 오버\n Score " + tetris.score + "\n 다시 시작하시겠습니까?", "정보", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
          tetris.restart();
          repaint();
          timer.restart();
        } else {
          main.navigate(new HomeView(main));
        }
      }
    };

    timer = new Timer(500, gameLoop);
    timer.setInitialDelay(1000);
    timer.start();

    String HOME_IMG_PATH =
        "res" + File.separator + "Tetrominos" + File.separator + "bg_btn_home.png";
    Image img = Toolkit.getDefaultToolkit().getImage(HOME_IMG_PATH).getScaledInstance(50, 50,
        java.awt.Image.SCALE_SMOOTH);

    JLabel homeLabel = new JLabel(new ImageIcon(img));
    homeLabel.setBounds(624, 10, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        timer.stop();
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);

    // init keyListener
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        handleUserInput(e.getKeyCode());
      }
    });

  }

  private void handleUserInput(int keyCode) {
    if (tetris.state == -1) {
      return;
    }

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
    int width = 12 * BOX_SIZE;
    int height = 22 * BOX_SIZE;

    // background
    g.drawImage(bg, 0, 0, width, height, this);

    // Score Board
    g.setColor(Color.black);
    g.fillRect(width + 10, 25, 200, 50);
    g.setColor(Color.white);
    g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    g.drawString("SCORE : " + Integer.toString(tetris.score), width + 20, 55);

    // Next Block
    g.drawRect(width + 10, 75, 200, 175);
    g.setColor(Color.black);
    g.fillRect(width + 10, 75, 200, 175);
    g.drawImage(shapeImg[tetris.getNextBlock()], width + 30, 100, this);
    g.setColor(Color.white);
    g.drawString("NEXT BLOCK", width + 20, 80);

    // Board
    // 블록 생성을 위한 보이지않는 두 줄이 존재함
    for (int i = 2; i < Board.HEIGHT + 2; i++) {
      for (int j = 0; j < Board.WIDTH; j++) {
        int type = board.map[i][j];
        g.drawImage(blockImg[type], (j + 1) * BOX_SIZE, (i - 1) * BOX_SIZE, this);
      }
    }
  }// end paint()

  private Image getResizeImg(String imgPath, int width, int height) {
    return Toolkit.getDefaultToolkit().getImage(imgPath).getScaledInstance(width, height,
        java.awt.Image.SCALE_SMOOTH);
  }
} // end getBlockImg()

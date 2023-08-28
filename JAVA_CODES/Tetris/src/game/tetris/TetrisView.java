package game.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
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

  // member 변수
  private Main main;
  private UserDTO user;
  private TetrisDAO dao;

  private Tetris tetris;
  private Board board;
  private Timer timer;
  private TetrisSoundManager sm;
  private Date startTime;
  private Date prevTime;
  private KeyListener tetrisKeyListener;

  private Image bg;
  private Image[] blockImg;
  private Image[] shapeImg;

  public TetrisView(Main main) {
    // 멤버 변수 초기화
    this.main = main;
    user = main.user;
    dao = TetrisDAOImpl.getInstance();
    sm = TetrisSoundManager.getInstance();
    tetris = new Tetris();
    board = tetris.board;
    tetrisKeyListener = new TetrisKeyListener(tetris, this);
    startTime = new Date();
    prevTime = startTime;
    replay = new LinkedList<>();
    timer = new Timer(500, actionEvent -> update());
    timer.setInitialDelay(1000);
    initialize();
  }

  private void initialize() {
    setBackground(Color.GRAY);
    setBounds(0, 0, 700, 699);
    setLayout(null);

    // init images
    bg = getResizeImg(BACKGROUD_IMG_PATH + "Board.png", 12 * BOX_SIZE, 22 * BOX_SIZE);
    blockImg = new Image[9];
    blockImg[0] = getResizeImg(BACKGROUD_IMG_PATH + "BG_1.png", BOX_SIZE, BOX_SIZE);
    blockImg[1] = getResizeImg(BLOCK_IMG_PATH + "Blue.png", BOX_SIZE, BOX_SIZE);
    blockImg[2] = getResizeImg(BLOCK_IMG_PATH + "Green.png", BOX_SIZE, BOX_SIZE);
    blockImg[3] = getResizeImg(BLOCK_IMG_PATH + "LightBlue.png", BOX_SIZE, BOX_SIZE);
    blockImg[4] = getResizeImg(BLOCK_IMG_PATH + "Orange.png", BOX_SIZE, BOX_SIZE);
    blockImg[5] = getResizeImg(BLOCK_IMG_PATH + "Purple.png", BOX_SIZE, BOX_SIZE);
    blockImg[6] = getResizeImg(BLOCK_IMG_PATH + "Red.png", BOX_SIZE, BOX_SIZE);
    blockImg[7] = getResizeImg(BLOCK_IMG_PATH + "Yellow.png", BOX_SIZE, BOX_SIZE);
    blockImg[8] = getResizeImg(BLOCK_IMG_PATH + "Single.png", BOX_SIZE, BOX_SIZE);

    shapeImg = new Image[8];
    shapeImg[0] = getResizeImg(BLOCK_IMG_PATH + "Single.png", BOX_SIZE, BOX_SIZE);
    shapeImg[1] = getResizeImg(SHAPE_IMG_PATH + "J.png", BOX_SIZE * 3, BOX_SIZE * 2);
    shapeImg[2] = getResizeImg(SHAPE_IMG_PATH + "S.png", BOX_SIZE * 3, BOX_SIZE * 2);
    shapeImg[3] = getResizeImg(SHAPE_IMG_PATH + "I.png", BOX_SIZE * 4, BOX_SIZE * 1);
    shapeImg[4] = getResizeImg(SHAPE_IMG_PATH + "L.png", BOX_SIZE * 3, BOX_SIZE * 2);
    shapeImg[5] = getResizeImg(SHAPE_IMG_PATH + "T.png", BOX_SIZE * 3, BOX_SIZE * 2);
    shapeImg[6] = getResizeImg(SHAPE_IMG_PATH + "Z.png", BOX_SIZE * 3, BOX_SIZE * 2);
    shapeImg[7] = getResizeImg(SHAPE_IMG_PATH + "O.png", BOX_SIZE * 2, BOX_SIZE * 2);

    JLabel homeLabel = new HomeLabel(50, 50);
    homeLabel.setBounds(624, 10, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        timer.stop();
        main.navigate(new HomeView(main));
        sm.stop();
      }
    });
    add(homeLabel);

    addKeyListener(tetrisKeyListener);
    timer.start();
    sm.reStart();
  }

  private void update() {
    tetris.down();
    repaint();
    if (tetris.state == Tetris.GAME_OVER) {
      handleGameOver();
    }
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    int width = 12 * BOX_SIZE;
    int height = 22 * BOX_SIZE;

    // 일시정지 판별
    if (tetris.state == Tetris.GAME_PAUSE) {
      g.setColor(Color.white);
      g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      g.drawString("Press ESC to RESUME", this.getWidth() / 2 - 100, this.getHeight() / 2);
      g.drawString("STOP", this.getWidth() / 2 - 20, this.getHeight() / 2 + 20);
      return;
    }

    // background
    g.drawImage(bg, 0, 0, width, height, this);

    // Score Board
    g.setColor(Color.white);
    g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    g.drawString("SCORE : " + Integer.toString(tetris.score), width + 20, 55);

    // Next Block
    g.drawImage(shapeImg[tetris.getNextBlock()], width + 30, 100, this);
    g.setColor(Color.white);
    g.drawString("NEXT BLOCK", width + 20, 80);

    // Saved Block
    g.drawString("SAVED BLOCK", width + 20, 200);
    g.drawImage(shapeImg[tetris.savedTetrominoCode], width + 30, 250, this);

    // Description
    g.setColor(Color.white);
    g.drawString("HOW TO PLAY", width + 20, 400);

    g.drawString("Left:", width + 20, 430);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_LEFT), width + 200, 430);

    g.drawString("Right:", width + 20, 450);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_RIGHT), width + 200, 450);

    g.drawString("Rotate Left:", width + 20, 470);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ROTATE_LEFT), width + 200, 470);

    g.drawString("Rotate Right:", width + 20, 490);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ROTATE_RIGHT), width + 200, 490);

    g.drawString("Switch:", width + 20, 510);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_SWITCH), width + 200, 510);

    g.drawString("Hard Drop:", width + 20, 530);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_HARD_DROP), width + 200, 530);

    g.drawString("Pause/Resume:", width + 20, 550);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ESC), width + 200, 550);

    g.drawString(getPlayTime(), width + 20, 600);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ESC), width + 200, 550);

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
  }// end getResizeImg()

  private String getPlayTime() {
    Calendar c = Calendar.getInstance();
    c.setTime(startTime);
    Long start = c.getTimeInMillis();
    c.setTime(new Date());
    Long cur = c.getTimeInMillis();

    return "PlayTime : " + (cur - start) / 1000 + " seconds";
  } // end getPlayTime()

  private void handleGameOver() {
    timer.stop();
    sm.stop();
    dao.insert(user.getNo(), tetris.score);
    int result = JOptionPane.showConfirmDialog(this,
        "게임 오버\n Score " + tetris.score + "\n 다시 시작하시겠습니까?", "정보", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      tetris.restart();
      timer.restart();
      sm.reStart();
      repaint();
    } else {
      main.navigate(new HomeView(main));
    }
  } // end handleGameOver()

  public void toggleGamePause() {
    if (tetris.state == Tetris.GAME_PAUSE) {
      tetris.state = Tetris.GAME_NORMAL;
      timer.restart();
    } else {
      tetris.state = Tetris.GAME_PAUSE;
      timer.stop();
    }
  } // end toggleGamePause()
}

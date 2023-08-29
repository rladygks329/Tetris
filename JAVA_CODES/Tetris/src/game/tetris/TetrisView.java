package game.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
  public static final int REPLAY_MODE = 1;
  public static final int PLAY_MODE = 2;

  private final int BOX_SIZE = 30;

  // member 변수
  private Main main;
  private TetrisDAO dao;

  private int mode;
  private Tetris tetris;
  private TetrisSoundManager sm;
  private Timer timer;
  private Timer speedUpTimer;

  private Date prevDate;
  private List<ReplayAtom> replay;

  private String url;

  private Image bg;
  private Image[] blockImg;
  private Image[] shapeImg;

  public TetrisView(Main main, int mode, String url) {
    // 멤버 변수 초기화
    this.main = main;
    this.mode = mode;
    this.url = url;
    dao = TetrisDAOImpl.getInstance();
    sm = TetrisSoundManager.getInstance();
    sm.reStart();

    tetris = new Tetris();
    prevDate = new Date();
    replay = new LinkedList<>();

    if (mode == REPLAY_MODE) {
      initReplayMode();
    } else {
      initGameMode();
    }
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
        sm.stop();
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);
  }

  private void initGameMode() {
    addKeyListener(new TetrisKeyListener(tetris, this));
    timer = new Timer(1000, actionEvent -> {
      tetris.down();
      repaint();
      if (tetris.state == Tetris.GAME_OVER) {
        handleGameOver();
      }
    });
    timer.start();

    speedUpTimer = new Timer(20 * 1000, e -> {
      int delay = timer.getDelay();
      if (delay > 100) {
        delay -= 100;
      }
      timer.setDelay(delay);
    });
    speedUpTimer.start();
  }

  private void initReplayMode() {
    replay = ReplayFileManager.load(url);
    Iterator<ReplayAtom> iter = replay.iterator();

    if (replay.isEmpty()) {
      JOptionPane.showMessageDialog(this, "해당 파일이 손상 되었습니다.", "정보",
          JOptionPane.INFORMATION_MESSAGE);
    }

    timer = new Timer(1000, e -> {
      if (iter.hasNext()) {
        ReplayAtom atom = iter.next();
        tetris.board.map = atom.map;
        tetris.score = atom.score;
        tetris.savedTetrominoCode = atom.savedBlockCode;
        tetris.nextTetrominoCode = atom.nextBlockCode;
        timer.setDelay(atom.delay);
        repaint();
      } else {
        timer.stop();
        JOptionPane.showMessageDialog(this, "리플레이 종료!\n 점수: " + tetris.score, "정보",
            JOptionPane.INFORMATION_MESSAGE);
      }
    });
    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    if (mode == PLAY_MODE) {
      addReplayAtom();
    }

    if (tetris.state == Tetris.GAME_PAUSE) {
      drawPauseScene(g);
    } else {
      drawGameScene(g);
    }
  }// end paint()

  private void drawPauseScene(Graphics g) {
    g.setColor(Color.white);
    g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    g.drawString("Press " + KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ESC) + " to RESUME",
        this.getWidth() / 2 - 100, this.getHeight() / 2);
  } // end drawPauseScene()

  private void drawGameScene(Graphics g) {
    int width = 12 * BOX_SIZE;
    int height = 22 * BOX_SIZE;
    // background
    g.drawImage(bg, 0, 0, width, height, this);

    // Score Board
    g.setColor(Color.white);
    g.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    g.drawString("SCORE : " + Integer.toString(tetris.score), width + 20, 55);

    // Next Block
    g.drawImage(shapeImg[tetris.nextTetrominoCode], width + 30, 100, this);
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
    g.drawString("(once per block)", width + 20, 530);
    g.drawString("Hard Drop:", width + 20, 550);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_HARD_DROP), width + 200, 550);
    g.drawString("Pause/Resume:", width + 20, 570);
    g.drawString(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ESC), width + 200, 570);

    // Play time
    g.drawString(tetris.getPlayTime(), width + 20, 600);

    // Board
    for (int i = 0; i < Board.HEIGHT; i++) {
      for (int j = 0; j < Board.WIDTH; j++) {
        int type = tetris.board.map[i][j];
        g.drawImage(blockImg[type], (j + 1) * BOX_SIZE, (Board.HEIGHT - i) * BOX_SIZE, this);
      }
    }

  }// end drawGameScene()

  private Image getResizeImg(String imgPath, int width, int height) {
    return Toolkit.getDefaultToolkit().getImage(imgPath).getScaledInstance(width, height,
        java.awt.Image.SCALE_SMOOTH);
  }// end getResizeImg()


  private void addReplayAtom() {
    // caculate delay
    Calendar c = Calendar.getInstance();
    c.setTime(prevDate);
    long prev = c.getTimeInMillis();

    Date curDate = new Date();
    c.setTime(curDate);
    long cur = c.getTimeInMillis();

    // save atom
    ReplayAtom atom = new ReplayAtom(tetris, (int) (cur - prev));
    replay.add(atom);

    // update prevDate
    prevDate = curDate;
  }

  private void saveReplay() {
    UserDTO user = main.user;
    Date cur = new Date();
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String fileName = format.format(cur);
    String filePath = ReplayFileManager.getFilePath(user.getNo(), fileName);

    ReplayFileManager.save(user.getNo(), fileName, replay);
    dao.insert(user.getNo(), new ScoreDTO(-1, tetris.score, "", cur, filePath));
  }

  private void handleGameOver() {
    speedUpTimer.stop();
    timer.stop();
    sm.stop();

    saveReplay();
    int result = JOptionPane.showConfirmDialog(this,
        "게임 오버\n Score " + tetris.score + "\n 다시 시작하시겠습니까?", "정보", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      tetris.restart();
      timer.restart();
      timer.setDelay(1000);
      speedUpTimer.restart();
      sm.reStart();
      replay.clear();
      repaint();
    } else {
      main.navigate(new HomeView(main));
    }
  } // end handleGameOver()

  public void toggleGamePause() {
    if (tetris.state == Tetris.GAME_PAUSE) {
      prevDate = new Date();
      tetris.state = Tetris.GAME_NORMAL;
      timer.restart();
      speedUpTimer.restart();
    } else {
      tetris.state = Tetris.GAME_PAUSE;
      timer.stop();
      speedUpTimer.stop();
    }
  } // end toggleGamePause()
}

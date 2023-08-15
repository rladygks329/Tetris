package game.tetris;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main extends JPanel{
  private JFrame frame;
  int boxSize = 30;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Main() {
    initialize();
  }
  private void initialize() {

    frame = new JFrame();
    frame.setFocusable(true);
    frame.setBounds(100, 100, 720, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    TetrisView tv = new TetrisView();
    tv.setBounds(0, 0, 12 * boxSize, 22 * boxSize);
    tv.setBorder(new LineBorder(Color.ORANGE, 5));
    frame.getContentPane().add(tv);
  }

}

package game.tetris;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main extends JPanel {
  private JPanel contentPanel;
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
    frame.setBounds(100, 100, 470, 350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    System.out.println(this);
    LoginView l = new LoginView(this);
    l.setBounds(0, 0, 500, 500);
    l.setBorder(new LineBorder(Color.BLACK, 1));
    contentPanel = l;
    frame.getContentPane().add(l);

    // frame.setBounds(100, 100, 720, 699);
    // TetrisView tv = new TetrisView();
    // tv.setBounds(0, 0, 12 * boxSize, 22 * boxSize);
    // tv.setBorder(new LineBorder(Color.BLACK, 1));
    // tv.setFocusable(true);
    // tv.requestFocusInWindow();
    // frame.getContentPane().add(tv);
  }

  public void navigate(JPanel panel) {
    if (panel instanceof TetrisView) {
      // 현재 panel 지우기
      frame.getContentPane().remove(contentPanel);
      frame.revalidate();
      frame.repaint();

      // 테트리스 뷰 설정하기
      TetrisView tv = (TetrisView) panel;
      frame.setBounds(0, 0, 700, 699);
      tv.setBounds(0, 0, 12 * boxSize, 22 * boxSize);
      tv.setBorder(new LineBorder(Color.BLACK, 1));
      contentPanel = tv;

      // panel 추가하고 다시 그리기
      frame.getContentPane().add(tv);
      tv.requestFocusInWindow();
      frame.revalidate();
      frame.repaint();
    }

  }// end navigate
}// end Main

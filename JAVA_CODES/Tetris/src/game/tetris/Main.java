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
    frame.setTitle("TETRIS");
    frame.setBounds(100, 100, 470, 350);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    System.out.println(this);
    SignInView l = new SignInView(this);
    l.setBounds(0, 0, 500, 500);
    l.setBorder(new LineBorder(Color.BLACK, 1));
    contentPanel = l;
    frame.getContentPane().add(l);
  }

  public void navigate(JPanel panel) {
    // 현재 panel 지우기
    frame.getContentPane().remove(contentPanel);
    frame.revalidate();
    frame.repaint();

    contentPanel = panel;
    frame.setBounds(panel.getBounds());

    // panel 추가하고 다시 그리기
    frame.getContentPane().add(panel);
    panel.requestFocusInWindow();
    frame.revalidate();
    frame.repaint();

  }// end navigate
}// end Main

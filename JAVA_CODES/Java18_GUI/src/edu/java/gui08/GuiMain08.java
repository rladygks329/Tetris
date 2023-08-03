package edu.java.gui08;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GuiMain08 {

  private JFrame frame;

  private final ImageIcon[] IMAGE_ICONS = {new ImageIcon("res/dog1.jpg"),
      new ImageIcon("res/dog2.jpg"), new ImageIcon("res/dog3.jpg"), new ImageIcon("res/dog4.jpg")};
  private int index = 0;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain08 window = new GuiMain08();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GuiMain08() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 570);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblOutput = new JLabel(IMAGE_ICONS[0], SwingConstants.CENTER);
    lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblOutput.setBounds(31, 10, 380, 264);
    frame.getContentPane().add(lblOutput);

    JButton btnNext = new JButton("다음");
    btnNext.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    btnNext.setBounds(252, 316, 159, 58);
    frame.getContentPane().add(btnNext);
    btnNext.addActionListener(e -> {
      index = (index + 1) % IMAGE_ICONS.length;
      lblOutput.setIcon(IMAGE_ICONS[index]);
    });

    JButton btnPrev = new JButton("이전");
    btnPrev.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    btnPrev.setBounds(30, 316, 159, 58);
    frame.getContentPane().add(btnPrev);
    btnPrev.addActionListener(e -> {
      index = (IMAGE_ICONS.length + index - 1) % IMAGE_ICONS.length;
      lblOutput.setIcon(IMAGE_ICONS[index]);
    });
  } // end initialize()

}// end GuiMain08

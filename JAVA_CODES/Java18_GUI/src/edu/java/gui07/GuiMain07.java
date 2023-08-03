package edu.java.gui07;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GuiMain07 {

  private JFrame frame;
  private JLabel lblOutput;
  private final String[] STRINGS = {"1. 강정묵", "2. 곽동훈", "3. 김빛찬", "4. 김성훈", "5. 김요한", "6. 김홍석",
      "7. 박진성", "8. 서해용", "9. 안성원", "10. 이동건", "11. 전황", "12. 조성하", "13. 조학용"};
  private int index = 0;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain07 window = new GuiMain07();
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
  public GuiMain07() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    lblOutput = new JLabel(STRINGS[0]);
    lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
    lblOutput.setBounds(31, 10, 380, 80);
    frame.getContentPane().add(lblOutput);

    JButton btnNext = new JButton("다음");
    btnNext.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    btnNext.setBounds(252, 100, 159, 58);
    frame.getContentPane().add(btnNext);
    btnNext.addActionListener(e -> {
      index = (index + 1) % STRINGS.length;
      lblOutput.setText(STRINGS[index]);
    });


    JButton btnPrev = new JButton("이전");
    btnPrev.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
    btnPrev.setBounds(31, 100, 159, 58);
    frame.getContentPane().add(btnPrev);
    btnPrev.addActionListener(e -> {
      index = (STRINGS.length + index - 1) % STRINGS.length;
      lblOutput.setText(STRINGS[index]);
    });
  } // end initialize
} // end GuiMain07

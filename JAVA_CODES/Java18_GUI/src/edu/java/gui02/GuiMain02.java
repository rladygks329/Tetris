package edu.java.gui02;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiMain02 {

  private JFrame frame;
  private JTextField txtInput;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain02 window = new GuiMain02();
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
  public GuiMain02() {
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

    JLabel lblOutput = new JLabel("오늘은 수요일 입니다.");
    lblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
    lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
    lblOutput.setForeground(new Color(51, 153, 204));
    lblOutput.setBounds(12, 10, 410, 47);
    frame.getContentPane().add(lblOutput);

    JButton btnInput = new JButton("입력");
    btnInput.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        // 버튼을 클릭했을 때 해야할 기능을 구현
        // JTextField에 입력된 내용을 읽어서 JLabel에 적용
        String input = txtInput.getText();
        lblOutput.setText(input);
        System.out.println("버튼 누름");
      }
    });
    btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 18));
    btnInput.setBounds(12, 130, 410, 105);
    frame.getContentPane().add(btnInput);
    System.out.println("메소드 호출 끝");

    txtInput = new JTextField();
    txtInput.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
    txtInput.setHorizontalAlignment(SwingConstants.CENTER);
    txtInput.setBounds(12, 73, 410, 47);
    frame.getContentPane().add(txtInput);
    txtInput.setColumns(10);
  }
}

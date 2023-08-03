package edu.java.gui11;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiMain11 {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain11 window = new GuiMain11();
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
  public GuiMain11() {
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

    JButton btn1 = new JButton("New Frame");
    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // JFrame myFrame = new JFrame()
        // myFrame.setBounds(10, 10, 400, 400)
        // myFrame.setVisible(true)
        // 일반적으로 새로운 프레임이나, 다이얼로그를 생성할 때는
        // 각 클래스를 상속받는 자식 클래스를 만들어서 사용하는 것이
        // 편의성 면에서 더 좋음
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
        // frame.setVisible(false); // 메인 프레임을 안보이게
      }
    });
    btn1.setFont(new Font("굴림", Font.BOLD, 30));
    btn1.setBounds(24, 21, 398, 82);
    frame.getContentPane().add(btn1);

    JButton btn2 = new JButton("New Dialog");
    btn2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MyDialog myDialog = new MyDialog();
        myDialog.setVisible(true);
      }
    });
    btn2.setFont(new Font("굴림", Font.BOLD, 30));
    btn2.setBounds(24, 124, 398, 82);
    frame.getContentPane().add(btn2);
  } // end initialize()

} // end GuiMain11

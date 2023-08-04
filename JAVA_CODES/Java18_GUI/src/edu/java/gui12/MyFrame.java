package edu.java.gui12;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

  private JPanel contentPane;

  public MyFrame(String text) {

    // JFrame.EXIT.ON.CLOSE : 프로그램 전체 종료
    // Jframe.DISPOSE_ON_CLOSE : 현재 창만 종료
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 종료 버튼 옵션 설정
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel(); // frame.getContentPane() 과 동일
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);

    JButton btnNewButton = new JButton(text);
    contentPane.add(btnNewButton);
  }

}

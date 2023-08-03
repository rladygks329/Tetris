package edu.java.gui10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class GuiMain10 {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain10 window = new GuiMain10();
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
  public GuiMain10() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu menuFile = new JMenu("File");
    menuBar.add(menuFile);

    JMenuItem mntmOpen = new JMenuItem("Open");
    mntmOpen.addActionListener(e -> {
      // JFileChooser : 파일을 선택할 수 있는 팝업창
      JFileChooser chooser = new JFileChooser();
      int result = chooser.showOpenDialog(frame);
      if (result == JFileChooser.APPROVE_OPTION) {// 확인 버튼 클릭시
        File selected = chooser.getSelectedFile();
        System.out.println(selected.getAbsolutePath());
        System.out.println("파일 선택");
      } else { // 취소 버튼 클릭시
        System.out.println("취소");
      }
    });
    menuFile.add(mntmOpen);

    JMenuItem mntmSave = new JMenuItem("Save");
    menuFile.add(mntmSave);

    JSeparator separator = new JSeparator();
    menuFile.add(separator);

    JMenuItem mntmExit = new JMenuItem("Exit");
    mntmExit.addActionListener(e -> {
      // ConfirmDialog:
      // Yes(확인) - No(아니요) - Cancel(취소) 버튼을 갖는 다이얼로그
      int result = JOptionPane.showConfirmDialog(null, "종료 하시겠습니까?");
      // parentComponent : 부모 컴포넌트를 설정. 현재 컴포넌트가 출력될 위치 설정
      System.out.println("선택 결과 : " + result);
      if (result == JOptionPane.YES_OPTION) {
        // 프로그램 종료:
        // system.exit(0); 정상종료
        // system.exit(0 이외의 숫자); : 비정상종료
        System.exit(0);
      } else {
        System.out.println("취소");
      }
    });
    menuFile.add(mntmExit);

    JMenu mnHelp = new JMenu("Help");
    menuBar.add(mnHelp);

    JMenuItem mntmAbout = new JMenuItem("about");
    mntmAbout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // 메시지와 Ok 버튼만 있는 다이얼로그 : MessageDialog
        JOptionPane.showMessageDialog(frame, "버전 1.0");
      }
    });
    mnHelp.add(mntmAbout);
  }// end initialize

}// end GuiMain10

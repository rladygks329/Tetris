package edu.java.gui05;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class GuiMain05 {

  private JFrame frame;
  private JTextArea textArea;
  private final ButtonGroup buttonGroup = new ButtonGroup();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain05 window = new GuiMain05();
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
  public GuiMain05() {
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

    textArea = new JTextArea();
    textArea.setBounds(8, 47, 414, 204);
    frame.getContentPane().add(textArea);

    JRadioButton rbtnAgree = new JRadioButton("동의");
    rbtnAgree.addActionListener(e -> textArea.setText(rbtnAgree.getText()));

    rbtnAgree.setSelected(true);
    buttonGroup.add(rbtnAgree);
    rbtnAgree.setBounds(8, 6, 126, 35);
    frame.getContentPane().add(rbtnAgree);

    JRadioButton rdbtnReject = new JRadioButton("거절");
    rdbtnReject.addActionListener(e -> textArea.setText(rdbtnReject.getText()));
    buttonGroup.add(rdbtnReject);
    rdbtnReject.setBounds(156, 6, 126, 35);
    frame.getContentPane().add(rdbtnReject);


  }// end initialize()
}// end GuiMain05

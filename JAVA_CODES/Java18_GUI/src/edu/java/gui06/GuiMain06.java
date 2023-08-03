package edu.java.gui06;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class GuiMain06 {

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
          GuiMain06 window = new GuiMain06();
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
  public GuiMain06() {
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
    textArea.setBounds(8, 92, 414, 159);
    frame.getContentPane().add(textArea);

    JRadioButton rdbtnMale = new JRadioButton("남자");
    rdbtnMale.setSelected(true);
    buttonGroup.add(rdbtnMale);
    rdbtnMale.setBounds(8, 6, 126, 35);
    frame.getContentPane().add(rdbtnMale);

    JRadioButton rdbtnFemale = new JRadioButton("여자");
    buttonGroup.add(rdbtnFemale);
    rdbtnFemale.setBounds(156, 6, 126, 35);
    frame.getContentPane().add(rdbtnFemale);


    JButton btnCheck = new JButton("확인");
    btnCheck.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String selection = "성별 : " + rdbtnMale.getText();
        if (rdbtnFemale.isSelected()) {
          selection = "성별 : " + rdbtnFemale.getText();
        }
        textArea.setText(selection);
      }
    });
    btnCheck.setBounds(8, 47, 97, 35);
    frame.getContentPane().add(btnCheck);
  }// end initialize()
} // end GuiMain06

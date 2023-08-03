package edu.java.gui09;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GuiMain09 {

  private JFrame frame;
  private JTextArea textArea;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain09 window = new GuiMain09();
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
  public GuiMain09() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 508, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JCheckBox chckbxMusic = new JCheckBox("음악");
    chckbxMusic.setBounds(8, 6, 115, 23);
    frame.getContentPane().add(chckbxMusic);

    JCheckBox chckbxMovie = new JCheckBox("영화");
    chckbxMovie.setBounds(130, 6, 115, 23);
    frame.getContentPane().add(chckbxMovie);

    JCheckBox chckbxReading = new JCheckBox("독서");
    chckbxReading.addActionListener(e -> textArea.setEnabled(!chckbxReading.isSelected()));
    chckbxReading.setBounds(249, 6, 115, 23);
    frame.getContentPane().add(chckbxReading);

    textArea = new JTextArea();
    textArea.setBounds(8, 35, 472, 216);
    frame.getContentPane().add(textArea);

    JButton btnOutput = new JButton("출력");
    btnOutput.setBounds(372, 6, 97, 23);
    frame.getContentPane().add(btnOutput);
    btnOutput.addActionListener(e -> {
      String result = "음악 : " + chckbxMusic.isSelected() + "\n " + "영화 : "
          + chckbxMovie.isSelected() + "\n" + "독서 : " + chckbxReading.isSelected() + "\n";
      textArea.setText(result);
    });
  }// end initialize()
}// end GuiMain09

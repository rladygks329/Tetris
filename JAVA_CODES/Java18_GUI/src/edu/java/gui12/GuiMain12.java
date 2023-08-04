package edu.java.gui12;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiMain12 {

  private JFrame frame;
  private JTextField textField;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain12 window = new GuiMain12();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public GuiMain12() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    textField = new JTextField();
    textField.setBounds(31, 33, 369, 72);
    frame.getContentPane().add(textField);
    textField.setColumns(10);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(e -> {
      String text = textField.getText();
      MyFrame myFrame = new MyFrame(text);
      myFrame.setVisible(true);
    });
    btnNewButton.setBounds(31, 115, 369, 115);
    frame.getContentPane().add(btnNewButton);
  }// end initialize
} // end GuiMain12

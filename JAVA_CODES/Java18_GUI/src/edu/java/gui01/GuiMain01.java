package edu.java.gui01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain01 {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain01 window = new GuiMain01();
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
  public GuiMain01() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel northlbl = new JLabel("North");
    frame.getContentPane().add(northlbl, BorderLayout.NORTH);

    JLabel westlbl = new JLabel("west");
    frame.getContentPane().add(westlbl, BorderLayout.WEST);

    JLabel centerlbl = new JLabel("Center");
    frame.getContentPane().add(centerlbl, BorderLayout.CENTER);

    JLabel eastlnl = new JLabel("East");
    frame.getContentPane().add(eastlnl, BorderLayout.EAST);

    JLabel southlbl = new JLabel("South");
    frame.getContentPane().add(southlbl, BorderLayout.SOUTH);
  }

}

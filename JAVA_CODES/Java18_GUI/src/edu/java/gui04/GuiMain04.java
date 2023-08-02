package edu.java.gui04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiMain04 {

  private JFrame frame;
  private JTextField txtNum1;
  private JTextField txtNum2;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        GuiMain04 window = new GuiMain04();
        window.frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Create the application.
   * 
   * @wbp.parser.entryPoint
   */
  public GuiMain04() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 714, 454);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JLabel lblNum1 = new JLabel("Number 1");
    lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNum1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblNum1.setBounds(25, 38, 163, 65);
    frame.getContentPane().add(lblNum1);

    JLabel lblNum2 = new JLabel("Number 2");
    lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
    lblNum2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblNum2.setBounds(25, 127, 163, 65);
    frame.getContentPane().add(lblNum2);

    txtNum1 = new JTextField();
    txtNum1.setFont(new Font("굴림", Font.PLAIN, 20));
    txtNum1.setBounds(215, 46, 471, 54);
    frame.getContentPane().add(txtNum1);
    txtNum1.setColumns(10);

    txtNum2 = new JTextField();
    txtNum2.setFont(new Font("굴림", Font.PLAIN, 20));
    txtNum2.setColumns(10);
    txtNum2.setBounds(215, 135, 471, 54);
    frame.getContentPane().add(txtNum2);

    JButton btnAdd = new JButton("+");
    btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    btnAdd.setBounds(47, 216, 91, 54);
    frame.getContentPane().add(btnAdd);

    JButton btnMinus = new JButton("-");
    btnMinus.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    btnMinus.setBounds(219, 216, 91, 54);
    frame.getContentPane().add(btnMinus);

    JButton btnMulti = new JButton("*");
    btnMulti.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    btnMulti.setBounds(409, 216, 91, 54);
    frame.getContentPane().add(btnMulti);

    JButton btnDivide = new JButton("/");
    btnDivide.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    btnDivide.setBounds(581, 216, 91, 54);
    frame.getContentPane().add(btnDivide);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(25, 280, 661, 110);
    frame.getContentPane().add(scrollPane);

    JTextArea textResult = new JTextArea();
    textResult.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
    scrollPane.setViewportView(textResult);

    btnAdd.addActionListener(e -> {
      Double num1 = Double.parseDouble(txtNum1.getText());
      Double num2 = Double.parseDouble(txtNum2.getText());
      String result = num1 + " + " + num2 + " = " + (num1 + num2) + "\n";
      textResult.append(result);
    });

    btnMinus.addActionListener(e -> {
      Double num1 = Double.parseDouble(txtNum1.getText());
      Double num2 = Double.parseDouble(txtNum2.getText());
      String result = num1 + " - " + num2 + " = " + (num1 - num2) + "\n";
      textResult.append(result);
    });

    btnMulti.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          Double num1 = Double.parseDouble(txtNum1.getText());
          Double num2 = Double.parseDouble(txtNum2.getText());
          String result = num1 + " * " + num2 + " = " + (num1 * num2) + "\n";
          textResult.append(result);
        }
      }
    });

    btnDivide.addActionListener(e -> {
      Double num1 = Double.parseDouble(txtNum1.getText());
      Double num2 = Double.parseDouble(txtNum2.getText());
      String result = num1 + " / " + num2 + " = " + (num1 / num2) + "\n";
      textResult.append(result);
    });
  }// end initialize()

} // endGuiMain04

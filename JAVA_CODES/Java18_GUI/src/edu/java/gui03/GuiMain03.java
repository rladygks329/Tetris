package edu.java.gui03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiMain03 {

  private JFrame frame;
  private JTextField txtName;
  private JTextField txtPhone;
  private JTextField txtEmail;
  private JTextField txtInfo;
  private JTextArea textArea;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMain03 window = new GuiMain03();
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
  public GuiMain03() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 600, 750);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null); // Absolute layout

    int lblWidth = 245; // 레이블 넓이
    int lblHeight = 76; // 레이블 높이
    Font lblFont = new Font("굴림", Font.BOLD, 48);

    JLabel lblName = new JLabel("이름");
    lblName.setBounds(12, 10, lblWidth, lblHeight);
    lblName.setHorizontalAlignment(SwingConstants.CENTER);
    lblName.setFont(lblFont);
    lblName.setOpaque(true); // 배경색 설정을 위한 세팅
    lblName.setBackground(Color.PINK);
    frame.getContentPane().add(lblName);

    JLabel lblPhone = new JLabel("전화번호");
    lblPhone.setBounds(12, 96, lblWidth, lblHeight);
    lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
    lblPhone.setFont(lblFont);
    lblPhone.setOpaque(true); // 배경색 설정을 위한 세팅
    lblPhone.setBackground(Color.ORANGE);
    frame.getContentPane().add(lblPhone);

    JLabel lblEmail = new JLabel("이메일");
    lblEmail.setBounds(12, 182, lblWidth, lblHeight);
    lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
    lblEmail.setFont(lblFont);
    lblEmail.setOpaque(true); // 배경색 설정을 위한 세팅
    lblEmail.setBackground(new Color(30, 144, 255));
    frame.getContentPane().add(lblEmail);

    txtName = new JTextField();
    txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    txtName.setBounds(269, 10, 303, 76);
    frame.getContentPane().add(txtName);
    txtName.setColumns(10);

    txtPhone = new JTextField();
    txtPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    txtPhone.setBounds(269, 96, 303, 76);
    frame.getContentPane().add(txtPhone);
    txtPhone.setColumns(10);

    txtEmail = new JTextField();
    txtEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    txtEmail.setBounds(269, 182, 303, 76);
    frame.getContentPane().add(txtEmail);
    txtEmail.setColumns(10);

    JLabel lblNewLabel_3 = new JLabel("New label");
    lblNewLabel_3.setBounds(42, 234, 57, 15);
    frame.getContentPane().add(lblNewLabel_3);

    JButton btnSubmit = new JButton("정보 출력");
    btnSubmit.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    btnSubmit.setBounds(12, 268, 560, 94);
    frame.getContentPane().add(btnSubmit);

    txtInfo = new JTextField();
    txtInfo.setBounds(12, 372, 560, 124);
    frame.getContentPane().add(txtInfo);
    txtInfo.setColumns(10);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 506, 560, 181);
    frame.getContentPane().add(scrollPane);

    textArea = new JTextArea();
    scrollPane.setViewportView(textArea);

    btnSubmit.addActionListener(e -> {
      String name = txtName.getText();
      String phone = txtPhone.getText();
      String email = txtEmail.getText();

      String msg = "이름 : " + name + "\n" + "전화번호 : " + phone + "\n" + "이메일 : " + email + "\n";
      txtInfo.setText(msg);
      textArea.append(msg);
    });
  }
}// end GuiMain03

package game.tetris;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView extends JPanel {
  private JPasswordField passwordField;
  private JTextField textField;
  private JButton btnSubmit;

  private int KEY_CODE_ENTER = 10;

  public LoginView() {
    initialize();
  }

  private void initialize() {
    setBounds(100, 100, 450, 300);
    setLayout(null);
    JLabel lblTitle = new JLabel("TETRIS");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(150, 10, 142, 41);
    add(lblTitle);

    JLabel lblId = new JLabel("ID");
    lblId.setHorizontalAlignment(SwingConstants.LEFT);
    lblId.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblId.setBounds(12, 59, 135, 28);
    add(lblId);

    btnSubmit = new JButton("Log In");
    btnSubmit.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          handleSubmit();
        }
      }
    });
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleSubmit();
      }
    });
    btnSubmit.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    btnSubmit.setBounds(114, 238, 216, 41);
    add(btnSubmit);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblPassword.setBounds(12, 134, 135, 28);
    add(lblPassword);

    passwordField = new JPasswordField();
    passwordField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        btnSubmit.requestFocus();
      }
    });
    passwordField.setBounds(12, 169, 426, 34);
    add(passwordField);

    textField = new JTextField();
    textField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          passwordField.requestFocus();
        }
      }
    });
    textField.setBounds(12, 90, 426, 34);
    add(textField);
    textField.setColumns(10);

    JLabel lblSignUp = new JLabel("Sign Up");
    lblSignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    lblSignUp.setBounds(12, 213, 64, 15);
    add(lblSignUp);
  }

  private void handleSubmit() {
    String id = textField.getText();
    String password = new String(passwordField.getPassword());

    if (id.isBlank()) {
      Dialog dialog = new Dialog("ID를 입력해주세요.");
      dialog.setVisible(true);
      return;
    }

    if (password.isBlank()) {
      Dialog dialog = new Dialog("비밀번호를 입력해주세요.");
      dialog.setVisible(true);
      return;
    }
    System.out.println("handleSubmit");
  }
}

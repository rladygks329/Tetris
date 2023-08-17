package game.tetris;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUpView extends JPanel {
  private int KEY_CODE_ENTER = 10;

  private Main main;

  private JTextField textFieldId;
  private JPasswordField passwordField;
  private JTextField textFieldNickName;
  private JButton btnSubmit;

  public SignUpView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    setBounds(100, 100, 450, 350);
    setLayout(null);

    // <-- init Lables -->
    JLabel lblTitle = new JLabel("SignUp");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(150, 10, 142, 41);
    add(lblTitle);

    JLabel lblId = new JLabel("ID");
    lblId.setHorizontalAlignment(SwingConstants.LEFT);
    lblId.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblId.setBounds(12, 59, 135, 28);
    add(lblId);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblPassword.setBounds(12, 134, 135, 28);
    add(lblPassword);

    JLabel lblNick = new JLabel("NickName");
    lblNick.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblNick.setBounds(12, 213, 135, 28);
    add(lblNick);

    // <-- init textField -->
    textFieldId = new JTextField();
    textFieldId.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          passwordField.requestFocus();
        }
      }
    });
    textFieldId.setBounds(12, 90, 426, 34);
    add(textFieldId);
    textFieldId.setColumns(10);

    passwordField = new JPasswordField();
    passwordField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          textFieldNickName.requestFocus();
        }
      }
    });
    passwordField.setBounds(12, 169, 426, 34);
    add(passwordField);

    textFieldNickName = new JTextField();
    textFieldNickName.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          btnSubmit.requestFocus();
        }
      }
    });
    textFieldNickName.setColumns(10);
    textFieldNickName.setBounds(12, 251, 426, 34);
    add(textFieldNickName);

    // <-- init button -->
    btnSubmit = new JButton("Sign Up");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        handleSubmit();
      }
    });
    btnSubmit.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          handleSubmit();
        }
      }
    });
    btnSubmit.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    btnSubmit.setBounds(114, 301, 216, 41);
    add(btnSubmit);

    // panel에 focus를 받으면 input에 적용
    addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        textFieldId.requestFocus();
      }
    });
  }

  private void handleSubmit() {
    System.out.println("SignInView: handleSubmit");
    String id = textFieldId.getText();
    String password = new String(passwordField.getPassword());
    String nickName = textFieldNickName.getText();

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

    if (nickName.isBlank()) {
      Dialog dialog = new Dialog("닉네임을 입력해주세요.");
      dialog.setVisible(true);
      return;
    }

    System.out.println("handleSubmit");
    SignInView signInView = new SignInView(main);
    main.navigate(signInView);
  }
}

package game.tetris;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignInView extends JPanel {
  private int KEY_CODE_ENTER = 10;

  private Main main;

  private JPasswordField passwordField;
  private JTextField textField;
  private JButton btnSubmit;

  public SignInView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    setBounds(100, 100, 450, 300);
    setLayout(null);

    // <-- init Lables -->
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

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblPassword.setBounds(12, 134, 135, 28);
    add(lblPassword);

    JLabel lblSignUp = new JLabel("Sign Up");
    lblSignUp.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        navigateSignUp();
      }
    });
    lblSignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    lblSignUp.setBounds(12, 213, 64, 15);
    add(lblSignUp);


    // <-- init textField -- >
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

    passwordField = new JPasswordField();
    passwordField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          btnSubmit.requestFocus();
        }
      }
    });
    passwordField.setBounds(12, 169, 426, 34);
    add(passwordField);

    // <-- init buttton -->
    btnSubmit = new JButton("Log In");
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
    btnSubmit.setBounds(114, 238, 216, 41);
    add(btnSubmit);
  }

  private void handleSubmit() {
    System.out.println("SignInView: handleSubmit");
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
    main.navigate(new TetrisView());
  }

  private void navigateSignUp() {
    SignUpView signUpView = new SignUpView(main);
    main.navigate(signUpView);
  }
}
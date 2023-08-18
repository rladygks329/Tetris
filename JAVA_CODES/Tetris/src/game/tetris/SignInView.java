package game.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  private TetrisDAO dao;

  public SignInView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setBounds(100, 100, 470, 350);
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
    lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
    lblSignUp.setForeground(new Color(0, 153, 255));
    lblSignUp.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        navigateSignUp();
      }
    });
    lblSignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    lblSignUp.setBounds(12, 205, 50, 19);
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
    btnSubmit.addActionListener(e -> handleSubmit());
    btnSubmit.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KEY_CODE_ENTER) {
          handleSubmit();
        }
      }
    });
    btnSubmit.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    btnSubmit.setBounds(117, 235, 216, 41);
    add(btnSubmit);

    // panel에 focus를 받으면 input에 적용
    addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        textField.requestFocus();
      }
    });
  }

  private void handleSubmit() {
    String id = textField.getText();
    String password = new String(passwordField.getPassword());

    if (id.isBlank()) {
      JOptionPane.showMessageDialog(this, "ID를 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (password.isBlank()) {
      JOptionPane.showMessageDialog(this, "PASSWORD를 입력해주세요.", "정보",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    UserDTO user = dao.select(id, password);
    if (user == null) {
      JOptionPane.showMessageDialog(this, "ID와 비밀번호가 일치하는 유저를 찾을 수 없습니다.", "정보",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    main.user = user;
    main.navigate(new HomeView(main));
  }

  private void navigateSignUp() {
    SignUpView signUpView = new SignUpView(main);
    main.navigate(signUpView);
  }
}

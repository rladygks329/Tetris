package game.tetris;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUpView extends JPanel {
  private int KEY_CODE_ENTER = 10;

  private Main main;
  private TetrisDAO dao;

  private JTextField textFieldId;
  private JPasswordField passwordField;
  private JTextField textFieldNickName;
  private JButton btnSubmit;

  public SignUpView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setBounds(100, 100, 470, 400);
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
    btnSubmit.setBounds(114, 301, 216, 41);
    add(btnSubmit);

    JButton btnValidarteId = new JButton("중복 검사");
    btnValidarteId.addActionListener(e -> validateId());
    btnValidarteId.setBounds(341, 64, 97, 23);
    add(btnValidarteId);

    JButton btnValidateNickName = new JButton("중복 검사");
    btnValidateNickName.addActionListener(e -> validateNickName());
    btnValidateNickName.setBounds(341, 221, 97, 23);
    add(btnValidateNickName);

    // panel에 focus를 받으면 input에 적용
    addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        textFieldId.requestFocus();
      }
    });
  }

  private void handleSubmit() {
    String id = textFieldId.getText();
    String password = new String(passwordField.getPassword());
    String nickName = textFieldNickName.getText();

    if (id.isBlank()) {
      JOptionPane.showMessageDialog(this, "ID를 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (password.isBlank()) {
      JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (nickName.isBlank()) {
      JOptionPane.showMessageDialog(this, "닉네임을 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    int result = dao.insert(new UserDTO(-1, id, password, nickName));
    if (result != 1) {
      JOptionPane.showMessageDialog(this, "이미 존재하는 ID 또는 닉네임 입니다.", "정보",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    SignInView signInView = new SignInView(main);
    main.navigate(signInView);
  }

  private void validateId() {
    String id = textFieldId.getText();
    if (id.isBlank()) {
      JOptionPane.showMessageDialog(this, "ID를 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    String msg = (dao.selectById(id) == 0) ? "사용 가능한 ID입니다." : "중복된 ID입니다.";
    JOptionPane.showMessageDialog(this, msg, "정보", JOptionPane.INFORMATION_MESSAGE);
  }

  private void validateNickName() {
    String nickName = textFieldNickName.getText();

    if (nickName.isBlank()) {
      JOptionPane.showMessageDialog(this, "닉네임을 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String msg = (dao.selectByNickName(nickName) == 0) ? "사용 가능한 닉네임입니다." : "중복된 닉네임입니다.";
    JOptionPane.showMessageDialog(this, msg, "정보", JOptionPane.INFORMATION_MESSAGE);
  }
}

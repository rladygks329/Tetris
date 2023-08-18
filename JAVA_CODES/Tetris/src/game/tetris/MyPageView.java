package game.tetris;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyPageView extends JPanel {
  private Main main;
  private UserDTO user;
  private JTable table;
  private ScoreTableModel model;
  private JTextField textFieldNickName;
  private JTextField textFieldPassword;
  private JLabel lblTableName;
  private TetrisDAO dao;


  public MyPageView(Main main) {
    this.main = main;
    user = main.user;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setLayout(null);
    setBounds(100, 100, 480, 400);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(31, 120, 220, 231);
    add(scrollPane);

    // <-intit label->
    JLabel lblTitle = new JLabel("MyPage");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(132, 20, 171, 57);
    add(lblTitle);

    JLabel lblNickName = new JLabel("NickName");
    lblNickName.setBounds(276, 94, 75, 15);
    add(lblNickName);

    JLabel lblPassword = new JLabel("password");
    lblPassword.setBounds(276, 214, 57, 15);
    add(lblPassword);

    lblTableName = new JLabel(user.getNickName() + " 님의 기록");
    lblTableName.setBounds(31, 87, 111, 29);
    add(lblTableName);

    String HOME_IMG_PATH =
        "res" + File.separator + "Tetrominos" + File.separator + "bg_btn_home.png";
    Image img = Toolkit.getDefaultToolkit().getImage(HOME_IMG_PATH).getScaledInstance(50, 50,
        java.awt.Image.SCALE_SMOOTH);

    JLabel homeLabel = new JLabel(new ImageIcon(img));
    homeLabel.setBounds(388, 27, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);

    // <- init button ->
    JButton btnUpdateNickName = new JButton("닉네임 변경");
    btnUpdateNickName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    btnUpdateNickName.addActionListener(e -> updateNickName());
    btnUpdateNickName.setBounds(313, 164, 125, 29);
    add(btnUpdateNickName);

    JButton btnUpdatePassword = new JButton("비밀번호 변경");
    btnUpdatePassword.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    btnUpdatePassword.addActionListener(e -> updatePassword());
    btnUpdatePassword.setBounds(313, 283, 125, 29);
    add(btnUpdatePassword);

    // <- init table ->
    table = new JTable();
    scrollPane.setViewportView(table);

    List<ScoreDTO> myRecods = dao.selectAll(user.getNo());
    model = new ScoreTableModel(myRecods);
    table.setModel(model);

    // <-init text field->
    textFieldNickName = new JTextField();
    textFieldNickName.setBounds(276, 120, 162, 34);
    add(textFieldNickName);
    textFieldNickName.setColumns(10);

    textFieldPassword = new JTextField();
    textFieldPassword.setColumns(10);
    textFieldPassword.setBounds(276, 239, 162, 34);
    add(textFieldPassword);
  }

  private void updateNickName() {
    String prevNickName = user.getNickName();
    String newNickName = textFieldNickName.getText();

    // 전처리
    if (newNickName.isBlank()) {
      JOptionPane.showMessageDialog(this, "닉네임을 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    // 업데이트
    user.setNickName(newNickName);
    int result = dao.update(user);

    // 결과 핸들링
    if (result != 1) {
      JOptionPane.showMessageDialog(this, "이미 존재하는 닉네임입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
      user.setNickName(prevNickName);
    } else {
      model = new ScoreTableModel(dao.selectAll(user.getNo()));
      table.setModel(model);
      lblTableName.setText(newNickName + "님의 기록");
    }
  }

  private void updatePassword() {
    String prevPassword = user.getPassword();
    String newPassword = textFieldPassword.getText();

    // 전처리
    if (newPassword.isBlank()) {
      JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    // 업데이트
    user.setPassword(newPassword);
    int result = dao.update(user);

    // 결과 핸들링
    if (result != 1) {
      JOptionPane.showMessageDialog(this, "오류 발생", "정보", JOptionPane.INFORMATION_MESSAGE);
      user.setPassword(prevPassword);
    }
  }
}

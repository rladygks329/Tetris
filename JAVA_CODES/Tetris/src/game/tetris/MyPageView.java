package game.tetris;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyPageView extends JPanel {
  private Main main;
  private JTable table;
  private JTextField textField;
  private JTextField textField_1;

  public MyPageView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    setLayout(null);
    setBounds(100, 100, 480, 400);

    JLabel lblTitle = new JLabel("MyPage");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(132, 20, 171, 57);
    add(lblTitle);

    JButton btnMyPage = new JButton("닉네임 변경");
    btnMyPage.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    btnMyPage.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {}
    });
    btnMyPage.setBounds(313, 164, 125, 29);
    add(btnMyPage);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(31, 120, 220, 231);
    add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);

    JLabel lblNewLabel = new JLabel("~~~ 님의 기록");
    lblNewLabel.setBounds(31, 87, 111, 29);
    add(lblNewLabel);

    String HOME_IMG_PATH =
        "res" + File.separator + "Tetriminos" + File.separator + "bg_btn_home.png";
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

    textField = new JTextField();
    textField.setBounds(276, 120, 162, 34);
    add(textField);
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(276, 239, 162, 34);
    add(textField_1);

    JButton btnQlalfqjsgh = new JButton("비밀번호 변경");
    btnQlalfqjsgh.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
    btnQlalfqjsgh.setBounds(313, 283, 125, 29);
    add(btnQlalfqjsgh);

    JLabel lblNewLabel_1 = new JLabel("NickName");
    lblNewLabel_1.setBounds(276, 94, 75, 15);
    add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("password");
    lblNewLabel_1_1.setBounds(276, 214, 57, 15);
    add(lblNewLabel_1_1);
  }
}

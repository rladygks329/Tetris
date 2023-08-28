package game.tetris;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomeView extends JPanel {
  private Main main;

  public HomeView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    setLayout(null);
    setBounds(100, 100, 654, 252);

    JLabel lblHome = new JLabel("HOME");
    lblHome.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblHome.setHorizontalAlignment(SwingConstants.CENTER);
    lblHome.setBounds(236, 10, 171, 57);
    add(lblHome);

    JButton btnPlay = new JButton("Play");
    btnPlay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    btnPlay.addActionListener(e -> main.navigate(new TetrisView(main)));
    btnPlay.setBounds(12, 107, 133, 84);
    add(btnPlay);

    JButton btnRanking = new JButton("Ranking");
    btnRanking.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    btnRanking.addActionListener(e -> main.navigate(new RankingView(main)));
    btnRanking.setBounds(157, 107, 136, 83);
    add(btnRanking);

    JButton btnMyPage = new JButton("MyPage");
    btnMyPage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    btnMyPage.addActionListener(e -> main.navigate(new MyPageView(main)));
    btnMyPage.setBounds(305, 107, 133, 84);
    add(btnMyPage);

    JButton btnKeySetting = new JButton("Key Settings");
    btnKeySetting.addActionListener(e -> main.navigate(new SettingsView(main)));
    btnKeySetting.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    btnKeySetting.setBounds(450, 107, 171, 84);
    add(btnKeySetting);
  }
}

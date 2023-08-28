package game.tetris;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class RankingView extends JPanel {
  private Main main;
  private JTable table;
  private ScoreTableModel model;
  private TetrisDAO dao;

  public RankingView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setLayout(null);
    setBounds(100, 100, 611, 480);

    JLabel lblTitle = new JLabel("Ranking");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(216, 20, 171, 57);
    add(lblTitle);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 120, 565, 294);
    add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);

    model = new ScoreTableModel(dao.selectAll());
    table.setModel(model);

    JLabel homeLabel = new HomeLabel(50, 50);
    homeLabel.setBounds(527, 20, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);

    JButton btnPlayReplay = new JButton("리플레이 보기");
    btnPlayReplay.addActionListener(e -> playReplay());
    btnPlayReplay.setBounds(454, 80, 123, 23);
    add(btnPlayReplay);
  }

  private void playReplay() {
    int[] selected = table.getSelectedRows();

    if (selected.length == 0) {
      JOptionPane.showMessageDialog(this, "리플레이를 선택해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (selected.length > 1) {
      JOptionPane.showMessageDialog(this, "하나만 선택해주세요.", "정보", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    int index = selected[0];
    String filePath = model.getFilePath(index);
    main.navigate(new TetrisView(main, TetrisView.REPLAY_MODE, filePath));
  }
}

package game.tetris;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class RankingView extends JPanel {
  private Main main;
  private JTable table;
  private TetrisDAO dao;

  public RankingView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    dao = TetrisDAOImpl.getInstance();
    setLayout(null);
    setBounds(100, 100, 470, 421);

    JLabel lblTitle = new JLabel("Ranking");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(132, 20, 171, 57);
    add(lblTitle);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 103, 426, 257);
    add(scrollPane);

    table = new JTable();
    scrollPane.setViewportView(table);

    ScoreTableModel m = new ScoreTableModel(dao.selectAll());
    table.setModel(m);

    JLabel homeLabel = new HomeLabel(50, 50);
    homeLabel.setBounds(388, 27, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);
  }
}

package game.tetris;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel {
  private String[] columnNames = {"Ranking", "Score", "NickName", "Time"};
  private Object[][] data;

  public ScoreTableModel(List<ScoreDTO> list) {
    int w = getColumnCount();
    int h = list.size();
    data = new Object[h][w];

    for (int i = 0; i < h; i++) {
      ScoreDTO dto = list.get(i);
      data[i] = new Object[] {i + 1, dto.getScore(), dto.getNickName(), dto.getTime()};
    }
  }

  @Override
  public int getRowCount() {
    return data.length;
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }
}

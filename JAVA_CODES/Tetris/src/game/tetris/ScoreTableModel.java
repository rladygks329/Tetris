package game.tetris;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel {
  private String[] columnNames = {"Ranking", "Score", "NickName", "Time"};
  private List<ScoreDTO> list;

  public ScoreTableModel(List<ScoreDTO> list) {
    this.list = list;
  }

  @Override
  public int getRowCount() {
    return list.size();
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
    Object result = null;
    ScoreDTO dto = list.get(rowIndex);
    switch (columnIndex) {
      case 0:
        result = rowIndex + 1;
        break;
      case 1:
        result = dto.getScore();
        break;
      case 2:
        result = dto.getNickName();
        break;
      case 3:
        result = dto.getTime();
        break;
      default:
        break;
    }
    return result;
  }

  public void removeRow(int rowIndex) {
    list.remove(rowIndex);
  }

  public int getScoreNo(int rowIndex) {
    return list.get(rowIndex).getScoreNo();
  }
}

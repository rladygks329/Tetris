package game.tetris;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HomeLabel extends JLabel {
  private String HOME_IMG_PATH =
      "res" + File.separator + "Tetrominos" + File.separator + "bg_btn_home.png";
  private Image img;

  public HomeLabel(int width, int height) {

    Image img = Toolkit.getDefaultToolkit().getImage(HOME_IMG_PATH).getScaledInstance(width, height,
        java.awt.Image.SCALE_SMOOTH);

    setIcon(new ImageIcon(img));
  }
}

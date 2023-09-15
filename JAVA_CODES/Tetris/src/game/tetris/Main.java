package game.tetris;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;

public class Main {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Main() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setFocusable(true);
    frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
      }
    });
    frame.setBounds(100, 100, 716, 716);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    int boxSize = 30;
    JLabel[][] blocks = new JLabel[6][4];

    Image bg = Toolkit.getDefaultToolkit().getImage("res\\Tetriminos\\Board\\Board.png");
    bg = bg.getScaledInstance(12 * boxSize, 22 * boxSize, java.awt.Image.SCALE_SMOOTH);

    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 12 * boxSize, 22 * boxSize);
    frame.getContentPane().add(layeredPane);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });
    btnNewButton.setBounds(440, 87, 97, 23);
    frame.getContentPane().add(btnNewButton);


    ImageIcon image = new ImageIcon(bg);
    JLabel jLabel = new JLabel(image);
    jLabel.setBounds(0, 0, 12 * boxSize, 22 * boxSize);
    layeredPane.add(jLabel, 1);

    int[][] map = {//
        {1, 1, 1, 1}, //
        {1, 0, 0, 1}, //
        {1, 0, 0, 1}, //
        {1, 0, 0, 1}, //
        {1, 0, 0, 1}, //
        {1, 1, 1, 1}, //
    };
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        JLabel block = new JLabel();
        block.setBounds((j + 1) * boxSize, (i + 1) * boxSize, boxSize - 1, boxSize - 1);
        LineBorder b2 = new LineBorder(Color.orange, 1);
        block.setBorder(b2);
        block.setHorizontalAlignment(JLabel.CENTER);
        // wall
        if (map[i][j] == 1) {
          block.setIcon(new ImageIcon("res\\Tetriminos\\Single Blocks\\Blue.png"));
        } else {
          block.setIcon(new ImageIcon("res\\Tetriminos\\Single Blocks\\Green.png"));
        }
        blocks[i][j] = block;
        layeredPane.add(block, 0);
      }
    }
  }
}

package game.tetris;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SettingsView extends JPanel {

  private JTextField textFieldDown;
  private Main main;
  private JTextField textFieldRotateLeft;
  private JTextField textFieldLeft;
  private JTextField textFieldRotateRight;
  private JTextField textFieldRight;
  private JTextField textFieldHardDrop;
  private JTextField textFieldStopResume;
  private JTextField textFieldSwitch;

  public SettingsView(Main main) {
    this.main = main;
    initialize();
  }

  private void initialize() {
    setBounds(100, 100, 591, 458);
    setLayout(null);

    JLabel lblTitle = new JLabel("Key Settings");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    lblTitle.setBounds(201, 10, 189, 61);
    add(lblTitle);

    JLabel homeLabel = new HomeLabel(50, 50);
    homeLabel.setBounds(507, 21, 50, 50);
    homeLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        main.navigate(new HomeView(main));
      }
    });
    add(homeLabel);

    JLabel lblDown = new JLabel("Down");
    lblDown.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblDown.setHorizontalAlignment(SwingConstants.LEFT);
    lblDown.setBounds(26, 92, 79, 40);
    add(lblDown);

    JLabel lblRotateLeft = new JLabel("Rotate Left");
    lblRotateLeft.setHorizontalAlignment(SwingConstants.LEFT);
    lblRotateLeft.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblRotateLeft.setBounds(303, 90, 87, 40);
    add(lblRotateLeft);

    JLabel lblLeft = new JLabel("Left");
    lblLeft.setHorizontalAlignment(SwingConstants.LEFT);
    lblLeft.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblLeft.setBounds(26, 154, 79, 40);
    add(lblLeft);

    JLabel lblRotateRight = new JLabel("Rotate Right");
    lblRotateRight.setHorizontalAlignment(SwingConstants.LEFT);
    lblRotateRight.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblRotateRight.setBounds(303, 154, 98, 40);
    add(lblRotateRight);

    JLabel lblRight = new JLabel("Right");
    lblRight.setHorizontalAlignment(SwingConstants.LEFT);
    lblRight.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblRight.setBounds(26, 214, 79, 40);
    add(lblRight);

    JLabel lblHardDrop = new JLabel("Hard Drop");
    lblHardDrop.setHorizontalAlignment(SwingConstants.LEFT);
    lblHardDrop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblHardDrop.setBounds(303, 214, 79, 40);
    add(lblHardDrop);

    JLabel lblStop = new JLabel("Stop / Resume");
    lblStop.setHorizontalAlignment(SwingConstants.LEFT);
    lblStop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblStop.setBounds(26, 270, 114, 40);
    add(lblStop);

    JLabel lblSwitch = new JLabel("Switch");
    lblSwitch.setHorizontalAlignment(SwingConstants.LEFT);
    lblSwitch.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    lblSwitch.setBounds(311, 270, 79, 40);
    add(lblSwitch);

    textFieldDown = new JTextField();
    textFieldDown.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_DOWN));
    textFieldDown.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldDown.setText(KeyEvent.getKeyText(e.getKeyCode()));
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }

    });
    textFieldDown.setBounds(147, 101, 144, 30);
    add(textFieldDown);
    textFieldDown.setColumns(10);

    textFieldRotateLeft = new JTextField();
    textFieldRotateLeft.setColumns(10);
    textFieldRotateLeft.setBounds(413, 99, 144, 30);
    add(textFieldRotateLeft);

    textFieldLeft = new JTextField();
    textFieldLeft.setColumns(10);
    textFieldLeft.setBounds(147, 163, 144, 30);
    add(textFieldLeft);

    textFieldRotateRight = new JTextField();
    textFieldRotateRight.setColumns(10);
    textFieldRotateRight.setBounds(413, 163, 144, 30);
    add(textFieldRotateRight);

    textFieldRight = new JTextField();
    textFieldRight.setColumns(10);
    textFieldRight.setBounds(144, 224, 144, 30);
    add(textFieldRight);

    textFieldHardDrop = new JTextField();
    textFieldHardDrop.setColumns(10);
    textFieldHardDrop.setBounds(413, 223, 144, 30);
    add(textFieldHardDrop);

    textFieldStopResume = new JTextField();
    textFieldStopResume.setColumns(10);
    textFieldStopResume.setBounds(144, 279, 144, 30);
    add(textFieldStopResume);

    textFieldSwitch = new JTextField();
    textFieldSwitch.setColumns(10);
    textFieldSwitch.setBounds(413, 279, 144, 30);
    add(textFieldSwitch);

    JButton btnConfirm = new JButton("Apply");
    btnConfirm.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    btnConfirm.setBounds(229, 359, 125, 40);
    add(btnConfirm);

  }

  private void applySettings() {

  }
}

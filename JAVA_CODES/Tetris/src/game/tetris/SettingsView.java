package game.tetris;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

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

  private HashMap<String, Integer> map;

  public SettingsView(Main main) {
    this.main = main;
    map = new HashMap<>();
    map.put("down", TetrisKeyListener.KEY_CODE_DOWN );
    map.put("left", TetrisKeyListener.KEY_CODE_LEFT );
    map.put("right", TetrisKeyListener.KEY_CODE_RIGHT );
    map.put("rotateL", TetrisKeyListener.KEY_CODE_ROTATE_LEFT );
    map.put("rotateR", TetrisKeyListener.KEY_CODE_ROTATE_RIGHT );
    map.put("hardDrop", TetrisKeyListener.KEY_CODE_HARD_DROP );
    map.put("pause", TetrisKeyListener.KEY_CODE_ESC);
    map.put("switch", TetrisKeyListener.KEY_CODE_SWITCH );
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
        map.put("down", e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldDown.setBounds(147, 101, 144, 30);
    add(textFieldDown);

    textFieldLeft = new JTextField();
    textFieldLeft.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_LEFT));
    textFieldLeft.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldLeft.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("left", e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldLeft.setColumns(10);
    textFieldLeft.setBounds(147, 163, 144, 30);
    add(textFieldLeft);

    textFieldRight = new JTextField();
    textFieldRight.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ROTATE_RIGHT));
    textFieldRight.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldRight.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("right", e.getKeyCode() );

      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldRight.setColumns(10);
    textFieldRight.setBounds(144, 224, 144, 30);
    add(textFieldRight);

    textFieldRotateLeft = new JTextField();
    textFieldRotateLeft.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ROTATE_LEFT));
    textFieldRotateLeft.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldRotateLeft.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("rotateL", e.getKeyCode() );
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldRotateLeft.setColumns(10);
    textFieldRotateLeft.setBounds(413, 99, 144, 30);
    add(textFieldRotateLeft);

    textFieldRotateRight = new JTextField();
    textFieldRotateRight.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ROTATE_RIGHT));
    textFieldRotateRight.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldRotateRight.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("rotateR", e.getKeyCode() );
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldRotateRight.setColumns(10);
    textFieldRotateRight.setBounds(413, 163, 144, 30);
    add(textFieldRotateRight);

    textFieldHardDrop = new JTextField();
    textFieldHardDrop.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_HARD_DROP));
    textFieldHardDrop.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldHardDrop.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("hardDrop", e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldHardDrop.setColumns(10);
    textFieldHardDrop.setBounds(413, 223, 144, 30);
    add(textFieldHardDrop);

    textFieldStopResume = new JTextField();
    textFieldStopResume.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_ESC));
    textFieldStopResume.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldStopResume.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("pause", e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldStopResume.setColumns(10);
    textFieldStopResume.setBounds(144, 279, 144, 30);
    add(textFieldStopResume);

    textFieldSwitch = new JTextField();
    textFieldSwitch.setText(KeyEvent.getKeyText(TetrisKeyListener.KEY_CODE_SWITCH));
    textFieldSwitch.addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        textFieldSwitch.setText(KeyEvent.getKeyText(e.getKeyCode()));
        map.put("switch", e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    });
    textFieldSwitch.setColumns(10);
    textFieldSwitch.setBounds(413, 279, 144, 30);
    add(textFieldSwitch);

    JButton btnConfirm = new JButton("Apply");
    btnConfirm.addActionListener(actionEvent -> applySettings());
    btnConfirm.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    btnConfirm.setBounds(229, 359, 125, 40);
    add(btnConfirm);

  }

  private void applySettings() {
    Integer[] values = map.values().stream().distinct().toArray(Integer[]::new);
    if(values.length < 8){
      JOptionPane.showMessageDialog(this, "중복된 값이 있으면 안됩니다.", "정보",
              JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    TetrisKeyListener.KEY_CODE_DOWN = map.get("down");
    TetrisKeyListener.KEY_CODE_LEFT = map.get("left");
    TetrisKeyListener.KEY_CODE_RIGHT = map.get("right");
    TetrisKeyListener.KEY_CODE_ROTATE_LEFT = map.get("rotateL");
    TetrisKeyListener.KEY_CODE_ROTATE_RIGHT = map.get("rotateR");
    TetrisKeyListener.KEY_CODE_HARD_DROP = map.get("hardDrop");
    TetrisKeyListener.KEY_CODE_ESC = map.get("pause");
    TetrisKeyListener.KEY_CODE_SWITCH = map.get("switch");

    JOptionPane.showMessageDialog(this, "변경되었습니다.", "정보",
            JOptionPane.INFORMATION_MESSAGE);
    main.navigate(new HomeView(main));
  }
}

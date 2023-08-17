package game.tetris;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Dialog extends JDialog {

  private final JPanel contentPanel = new JPanel();

  public Dialog(String msg) {
    setModal(true);
    setTitle("Warning");
    setBounds(100, 100, 456, 193);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    JLabel lblMsg = new JLabel("New label");
    lblMsg.setText(msg);
    lblMsg.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
    lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
    lblMsg.setBounds(5, 5, 424, 106);
    contentPanel.add(lblMsg);

    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
    getContentPane().add(buttonPane, BorderLayout.SOUTH);

    JButton okButton = new JButton("OK");
    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    okButton.setActionCommand("OK");
    buttonPane.add(okButton);

    getRootPane().setDefaultButton(okButton);

  }
}// end MyDialog

package edu.java.contact05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ContactApplication {

  private JFrame frame;
  private JTextField textName;
  private JTextField textPhone;
  private JTextField textEmail;
  private JTextField textIndex;
  private JTable table;
  private TextArea textLog;
  private JTextArea textResult;
  private ContactDAO dao;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContactApplication window = new ContactApplication();
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
  public ContactApplication() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {

    JButton btnSelect;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnAdd;
    JButton btnSelectAll;
    dao = ContactDAOIMple.getInstance();
    frame = new JFrame();
    frame.setBounds(100, 100, 755, 687);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    // < ================== labels =================>
    JLabel lblTitle = new JLabel("연락처 프로그램 ver 0.5");
    lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 25));
    lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
    lblTitle.setBounds(24, 10, 353, 43);
    frame.getContentPane().add(lblTitle);

    JLabel lblName = new JLabel("이름");
    lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    lblName.setBounds(24, 63, 116, 43);
    frame.getContentPane().add(lblName);

    JLabel lblPhone = new JLabel("전화번호");
    lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    lblPhone.setBounds(24, 102, 116, 43);
    frame.getContentPane().add(lblPhone);

    JLabel lblEmail = new JLabel("이메일");
    lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    lblEmail.setBounds(24, 150, 116, 43);
    frame.getContentPane().add(lblEmail);

    JLabel lblIndex = new JLabel("인덱스");
    lblIndex.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    lblIndex.setBounds(24, 198, 116, 43);
    frame.getContentPane().add(lblIndex);

    // <=============== TextField ================>
    textName = new JTextField();
    textName.setColumns(10);
    textName.setBounds(152, 63, 169, 38);
    frame.getContentPane().add(textName);

    textPhone = new JTextField();
    textPhone.setColumns(10);
    textPhone.setBounds(152, 108, 169, 38);
    frame.getContentPane().add(textPhone);

    textEmail = new JTextField();
    textEmail.setColumns(10);
    textEmail.setBounds(152, 156, 169, 38);
    frame.getContentPane().add(textEmail);

    textIndex = new JTextField();
    textIndex.setColumns(10);
    textIndex.setBounds(152, 204, 169, 38);
    frame.getContentPane().add(textIndex);

    // <=== buttton ===>
    btnAdd = new JButton("등록");
    btnAdd.setBounds(24, 260, 97, 23);
    frame.getContentPane().add(btnAdd);
    btnAdd.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();

        if (name.isBlank()) {
          log("이름을 입력해주세요.\n");
          return;
        }

        if (phone.isBlank()) {
          log("전화번호를 입력해주세요.\n");
          return;
        }

        if (email.isBlank()) {
          log("이메일을 입력해주세요.\n");
          return;
        }

        insertContact(new ContactDTO(name, phone, email));
      }
    });

    btnSelect = new JButton("검색");
    btnSelect.setBounds(133, 260, 97, 23);
    frame.getContentPane().add(btnSelect);
    btnSelect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String input = textIndex.getText();
          int index = Integer.parseInt(input);
          selectContactByIndex(index);
        } catch (NumberFormatException numberExceoption) {
          log("인덱스창에 올바른 숫자를 입력해주세요.\n");
        }
      }
    });

    btnUpdate = new JButton("수정");
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String input = textIndex.getText();
          String phone = textPhone.getText();
          String email = textEmail.getText();
          int index = Integer.parseInt(input);
          if (phone.isBlank()) {
            log("핸드폰 번호를 입력해주세요\n");
            return;
          }
          if (email.isBlank()) {
            log("이메일을 입력해주세요\n");
            return;
          }
          updateContact(index, phone, email);
        } catch (NumberFormatException numberExceoption) {
          log("인덱스창에 올바른 숫자를 입력해주세요.\n");
        }
      }
    });
    btnUpdate.setBounds(242, 260, 97, 23);
    frame.getContentPane().add(btnUpdate);

    btnDelete = new JButton("삭제");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          String input = textIndex.getText();
          int index = Integer.parseInt(input);
          deleteContact(index);
        } catch (NumberFormatException numberExceoption) {
          log("인덱스창에 올바른 숫자를 입력해주세요.\n");
        }
      }
    });
    btnDelete.setBounds(24, 293, 97, 23);
    frame.getContentPane().add(btnDelete);

    btnSelectAll = new JButton("전체 검색");
    btnSelectAll.addActionListener(e -> selectAllContact());
    btnSelectAll.setBounds(133, 293, 97, 23);
    frame.getContentPane().add(btnSelectAll);

    textLog = new TextArea();
    textLog.setBounds(20, 463, 367, 86);
    frame.getContentPane().add(textLog);


    JScrollPane scrollResult = new JScrollPane();
    scrollResult.setBounds(20, 329, 367, 115);
    frame.getContentPane().add(scrollResult);

    textResult = new JTextArea();
    scrollResult.setViewportView(textResult);

    JScrollPane scrollTable = new JScrollPane();
    scrollTable.setBounds(422, 313, 290, 309);
    frame.getContentPane().add(scrollTable);

    table = new JTable();
    scrollTable.setViewportView(table);
    table.setBorder(new LineBorder(new Color(0, 0, 0)));
    table.setToolTipText("Contact list");
    updateTable();
  }


  private void log(String message) {
    textLog.append(message);
  }

  private void insertContact(ContactDTO contact) {
    int result = dao.insert(contact);
    int size = ((ContactDAOIMple) dao).getSize();
    if (result == 1) {
      textResult.setText("등록된 연락처 갯수: " + size);
    } else {
      log("연락처 등록에 문제가 생겼습니다." + "\n");
    }
    updateTable();
  } // insertContact()

  private void updateTable() {
    List<ContactDTO> list = dao.select();
    String[] header = {"No", "이름", "전화번호", "이메일"};
    int row = list.size();
    int column = header.length;
    String[][] content = new String[row][column];

    DefaultTableModel model = new DefaultTableModel(header, 0);
    for (int i = 0; i < list.size(); i++) {
      ContactDTO c = list.get(i);
      content[i][0] = Integer.toString(i);
      content[i][1] = c.getName();
      content[i][2] = c.getPhone();
      content[i][3] = c.getEmail();
    }
    model.setDataVector(content, header);
    table.setModel(model);
  }

  private void selectAllContact() {
    StringBuilder result = new StringBuilder("=== 연락처 전체 정보 ===\n");
    List<ContactDTO> list = dao.select();

    for (int i = 0; i < list.size(); i++) {
      result.append("연락처[" + i + "]: " + list.get(i) + "\n");
    }

    textResult.setText(result.toString());
    updateTable();
  } // end selectAllContact()

  private void selectContactByIndex(int index) {
    int size = ((ContactDAOIMple) dao).getSize();
    if (index < 0 || size <= index) {
      log("해당하는 연락처 정보가 없습니다.\n");
      return;
    }
    ContactDTO selected = dao.select(index);
    textResult.setText(selected.toString());
  }// end selectContactByIndex()

  private void updateContact(int index, String phone, String email) {
    int size = ((ContactDAOIMple) dao).getSize();

    if (index < 0 || size <= index) {
      log("해당하는 연락처 정보가 없습니다.\n");
      return;
    }

    int result = dao.update(index, new ContactDTO("", phone, email));
    if (result == 1) {
      textResult.setText("연락처 수정에 성공하였습니다.\n");
    }
    updateTable();
  } // end updateContact()

  private void deleteContact(int index) {
    int size = ((ContactDAOIMple) dao).getSize();

    if (index < 0 || size <= index) {
      log("해당하는 연락처 정보가 없습니다.\n");
      return;
    }

    int result = dao.delete(index);
    if (result == 1) {
      textResult.setText("삭제에 성공하였습니다.\n");
    } else {
      log("삭제에 실패했습니다.\n");
    }
    updateTable();
  }// end deleteContact()
}

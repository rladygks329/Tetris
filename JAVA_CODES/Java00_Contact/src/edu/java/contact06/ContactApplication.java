package edu.java.contact06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ContactApplication {

  private JFrame frame;
  private JTextField textName;
  private JTextField textPhone;
  private JTextField textEmail;
  private JTextField textId;
  private TextArea txtAreaLog;
  private TextArea txtAreaInfo;

  private JTable table;
  private DefaultTableModel model;
  String[] header = {"No", "이름", "전화번호", "이메일"};

  private ContactDAO dao;


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
    dao = ContactDAOIMple.getInstance();
    frame = new JFrame();
    frame.setBounds(100, 100, 755, 687);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    // < ================== labels =================>
    JLabel lblTitle = new JLabel("연락처 프로그램 ver 0.6");
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

    JLabel lblContactID = new JLabel("ID");
    lblContactID.setFont(new Font("맑은 고딕", Font.BOLD, 16));
    lblContactID.setBounds(24, 198, 116, 43);
    frame.getContentPane().add(lblContactID);

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

    textId = new JTextField();
    textId.setColumns(10);
    textId.setBounds(152, 204, 169, 38);
    frame.getContentPane().add(textId);

    // <================ buttton ===============>
    JButton btnAdd = new JButton("등록");
    btnAdd.setBounds(24, 260, 97, 23);
    frame.getContentPane().add(btnAdd);
    btnAdd.addActionListener(e -> insertContact());

    JButton btnSelect = new JButton("검색");
    btnSelect.setBounds(133, 260, 97, 23);
    frame.getContentPane().add(btnSelect);
    btnSelect.addActionListener(e -> selectContactByContactId());

    JButton btnSelectAll = new JButton("전체 검색");
    btnSelectAll.addActionListener(e -> selectAllContactTable());
    btnSelectAll.setBounds(133, 293, 97, 23);
    frame.getContentPane().add(btnSelectAll);

    JButton btnUpdate = new JButton("수정");
    btnUpdate.addActionListener(e -> updateContact());
    btnUpdate.setBounds(242, 260, 97, 23);
    frame.getContentPane().add(btnUpdate);

    JButton btnDelete = new JButton("삭제");
    btnDelete.addActionListener(e -> deleteContact());
    btnDelete.setBounds(24, 293, 97, 23);
    frame.getContentPane().add(btnDelete);


    // <=== TextArea ====>
    txtAreaLog = new TextArea();
    txtAreaLog.setBounds(20, 463, 367, 147);
    txtAreaLog.setEditable(false);
    frame.getContentPane().add(txtAreaLog);

    txtAreaInfo = new TextArea();
    txtAreaInfo.setBounds(20, 329, 367, 115);
    txtAreaInfo.setEditable(false);
    frame.getContentPane().add(txtAreaInfo);

    // <== Table ==>
    JScrollPane scrollTable = new JScrollPane();
    scrollTable.setBounds(422, 329, 290, 281);
    frame.getContentPane().add(scrollTable);

    table = new JTable();
    scrollTable.setViewportView(table);
    table.setBorder(new LineBorder(new Color(0, 0, 0)));
    table.setToolTipText("Contact list");

    model = new DefaultTableModel(header, 0) {
      private static final long serialVersionUID = 1L;

      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow();
        System.out.println(index);
      }
    });

    table.setModel(model);
    selectAllContactTable();
  }

  private void insertContact() {
    String name = textName.getText();
    String phone = textPhone.getText();
    String email = textEmail.getText();

    if (name.isBlank()) {
      txtAreaLog.append("이름을 입력해주세요.\n");
      return;
    }

    if (phone.isBlank()) {
      txtAreaLog.append("전화번호를 입력해주세요.\n");
      return;
    }

    if (email.isBlank()) {
      txtAreaLog.append("이메일을 입력해주세요.\n");
      return;
    }

    int result = dao.insert(new ContactDTO(-1, name, phone, email));
    if (result == 1) {
      txtAreaInfo.setText(result + "개의 데이터가 추가 되었습니다.");
    } else {
      txtAreaLog.append("연락처 등록에 문제가 생겼습니다." + "\n");
    }
  } // insertContact()

  private void selectAllContactTable() {
    StringBuilder result = new StringBuilder("=== 연락처 전체 정보 ===\n");
    Object[] rowData = new String[header.length];
    List<ContactDTO> list = dao.select();
    model.setRowCount(0);
    for (int i = 0; i < list.size(); i++) {
      result.append("연락처[" + i + "]: " + list.get(i) + "\n");
      ContactDTO c = list.get(i);
      rowData[0] = Integer.toString(c.getContactId());
      rowData[1] = c.getName();
      rowData[2] = c.getPhone();
      rowData[3] = c.getEmail();
      model.addRow(rowData);
    }
    txtAreaInfo.setText(result.toString());
  } // end selectAllContact()

  private void selectContactByContactId() {
    int contactId = 0;

    try {
      String input = textId.getText();
      contactId = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("ID창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    ContactDTO selected = dao.select(contactId);
    if (selected != null) {
      txtAreaInfo.setText(selected.toString());
    } else {
      txtAreaLog.append("해당하는 연락처가 없습니다.\n");
    }
  }// end selectContactByContactId()

  private void updateContact() {
    String input = textId.getText();
    String name = textName.getText();
    String phone = textPhone.getText();
    String email = textEmail.getText();

    int contactId = 0;

    if (name.isBlank()) {
      txtAreaLog.append("이름를 입력해주세요\n");
      return;
    }
    if (phone.isBlank()) {
      txtAreaLog.append("핸드폰 번호를 입력해주세요\n");
      return;
    }
    if (email.isBlank()) {
      txtAreaLog.append("이메일을 입력해주세요\n");
      return;
    }

    try {
      contactId = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("ID창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    int result = dao.update(contactId, new ContactDTO(-1, name, phone, email));
    if (result == 1) {
      txtAreaInfo.setText("연락처 수정에 성공하였습니다.\n");
    }
  } // end updateContact()

  private void deleteContact() {
    int contactId = 0;

    try {
      String input = textId.getText();
      contactId = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("ID창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    int result = dao.delete(contactId);
    if (result == 1) {
      txtAreaInfo.setText("삭제에 성공하였습니다.\n");
    } else {
      txtAreaLog.append(textId.getText() + "에 해당하는 연락처가 없습니다.\n");
    }
  }// end deleteContact()
}// end ContactApplication

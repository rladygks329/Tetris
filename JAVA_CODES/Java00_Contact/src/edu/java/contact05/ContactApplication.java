package edu.java.contact05;

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
  private JTextField textIndex;
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

    // <================ buttton ===============>
    JButton btnAdd = new JButton("등록");
    btnAdd.setBounds(24, 260, 97, 23);
    frame.getContentPane().add(btnAdd);
    btnAdd.addActionListener(e -> insertContact());

    JButton btnSelect = new JButton("검색");
    btnSelect.setBounds(133, 260, 97, 23);
    frame.getContentPane().add(btnSelect);
    btnSelect.addActionListener(e -> selectContactByIndex());

    JButton btnSelectAll = new JButton("전체 검색");
    btnSelectAll.addActionListener(e -> selectAllContact());
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
      public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow();
        System.out.println(index);
      };
    });

    table.setModel(model);
    initTableData();
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

    int result = dao.insert(new ContactDTO(name, phone, email));
    int size = ((ContactDAOIMple) dao).getSize();
    if (result == 1) {
      txtAreaInfo.setText("연락처 등록 완료\n등록된 연락처 갯수: " + size + "\n");
      int index = model.getRowCount();
      Object[] tableRow = new Object[4];
      tableRow[0] = index;
      tableRow[1] = name;
      tableRow[2] = phone;
      tableRow[3] = email;
      model.addRow(tableRow);
    } else {
      txtAreaLog.append("연락처 등록에 문제가 생겼습니다." + "\n");
    }
  } // insertContact()

  private void initTableData() {
    List<ContactDTO> list = dao.select();
    String[] rowData = new String[header.length];
    for (int i = 0; i < list.size(); i++) {
      ContactDTO c = list.get(i);
      rowData[0] = Integer.toString(i);
      rowData[1] = c.getName();
      rowData[2] = c.getPhone();
      rowData[3] = c.getEmail();
      model.addRow(rowData);
    }
  }// end selectAllContactTable()

  private void selectAllContact() {
    StringBuilder result = new StringBuilder("=== 연락처 전체 정보 ===\n");
    List<ContactDTO> list = dao.select();

    for (int i = 0; i < list.size(); i++) {
      result.append("연락처[" + i + "]: " + list.get(i) + "\n");
    }

    txtAreaInfo.setText(result.toString());
  } // end selectAllContact()

  private void selectContactByIndex() {
    int index = 0;
    int size = ((ContactDAOIMple) dao).getSize();

    try {
      String input = textIndex.getText();
      index = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("인덱스창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    if (index < 0 || size <= index) {
      txtAreaLog.append("해당하는 연락처 정보가 없습니다.\n");
      return;
    }
    ContactDTO selected = dao.select(index);
    txtAreaInfo.setText(selected.toString());
  }// end selectContactByIndex()

  private void updateContact() {
    String input = textIndex.getText();
    String phone = textPhone.getText();
    String email = textEmail.getText();
    int index = 0;
    int size = ((ContactDAOIMple) dao).getSize();

    if (phone.isBlank()) {
      txtAreaLog.append("핸드폰 번호를 입력해주세요\n");
      return;
    }
    if (email.isBlank()) {
      txtAreaLog.append("이메일을 입력해주세요\n");
      return;
    }

    try {
      index = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("인덱스창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    if (index < 0 || size <= index) {
      txtAreaLog.append("해당하는 연락처 정보가 없습니다.\n");
      return;
    }

    int result = dao.update(index, new ContactDTO("", phone, email));
    if (result == 1) {
      txtAreaInfo.setText("연락처 수정에 성공하였습니다.\n");
    }
    model.setValueAt(phone, index, 2);
    model.setValueAt(email, index, 3);
  } // end updateContact()

  private void deleteContact() {
    int index = 0;
    int size = ((ContactDAOIMple) dao).getSize();

    try {
      String input = textIndex.getText();
      index = Integer.parseInt(input);
    } catch (NumberFormatException numberExceoption) {
      txtAreaLog.append("인덱스창에 올바른 숫자를 입력해주세요.\n");
      return;
    }

    if (index < 0 || size <= index) {
      txtAreaLog.append("해당하는 연락처 정보가 없습니다.\n");
      return;
    }

    int result = dao.delete(index);
    if (result == 1) {
      txtAreaInfo.setText("삭제에 성공하였습니다.\n");
    } else {
      txtAreaLog.append("삭제에 실패했습니다.\n");
    }
    model.removeRow(index);
  }// end deleteContact()
}// end ContactApplication

package edu.java.contact03;

import java.util.ArrayList;

public class ContactDAOIMple implements ContactDAO {

  private static ContactDAOIMple instance;

  private ContactDAOIMple() {}

  public static ContactDAOIMple getInstance() {
    if (instance == null) {
      instance = new ContactDAOIMple();
    }

    return instance;
  }

  private static final int MAX = 100;
  private ArrayList<ContactDTO> list = new ArrayList<>(MAX);

  public int getSize() {
    return list.size();
  }

  @Override
  public int insert(ContactDTO dto) {
    return list.add(dto) ? 1 : 0;
  }

  @Override
  public ArrayList<ContactDTO> select() {
    return list;
  }

  @Override
  public ContactDTO select(int index) {
    return list.get(index);
  }

  @Override
  public int update(int index, ContactDTO dto) {
    list.get(index).setEmail(dto.getEmail());
    list.get(index).setPhone(dto.getPhone());
    return 1;
  }

  @Override
  public int delete(int index) {
    list.remove(index);
    return 1;
  }
}

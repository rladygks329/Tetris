package edu.java.contact02;

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
  private ContactDTO[] list = new ContactDTO[MAX];
  private static int size;

  public int getSize() {
    return size;
  }

  @Override
  public int insert(ContactDTO dto) {
    if (size >= MAX) {
      return -1;
    }
    list[size++] = dto;
    return 1;
  }

  @Override
  public ContactDTO[] select() {
    return list;
  }

  @Override
  public ContactDTO select(int index) {
    return list[index];
  }

  @Override
  public int update(int index, ContactDTO dto) {
    list[index].setEmail(dto.getEmail());
    list[index].setPhone(dto.getPhone());
    return 1;
  }
}

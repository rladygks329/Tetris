package edu.java.contact02;

public interface ContactDAO {
  public abstract int insert(ContactDTO dto);

  public abstract ContactDTO[] select();

  public abstract ContactDTO select(int index);

  public abstract int update(int index, ContactDTO dto);
}

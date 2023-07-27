package edu.java.contact03;

import java.util.List;

public interface ContactDAO {
  public abstract int insert(ContactDTO dto);

  public abstract List<ContactDTO> select();

  public abstract ContactDTO select(int index);

  public abstract int update(int index, ContactDTO dto);

  public abstract int delete(int index);
}

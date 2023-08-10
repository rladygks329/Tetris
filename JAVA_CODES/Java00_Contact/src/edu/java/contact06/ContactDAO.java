package edu.java.contact06;

import java.util.List;

public interface ContactDAO {
  public abstract int insert(ContactDTO dto);

  public abstract List<ContactDTO> select();

  public abstract ContactDTO select(int contactId);

  public abstract int update(int contactId, ContactDTO dto);

  public abstract int delete(int contactId);
}

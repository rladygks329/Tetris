package edu.java.contact04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ContactDAOIMple implements ContactDAO {

  private static ContactDAOIMple instance;

  private ContactDAOIMple() {
    initDatDir();
    initDataFile();
  }

  public static ContactDAOIMple getInstance() {
    if (instance == null) {
      instance = new ContactDAOIMple();
    }

    return instance;
  }

  private ArrayList<ContactDTO> list = new ArrayList<>();

  // 데이터를 저장할 폴더와 파일 이름 정의
  private static final String DATA_DIR = "data";
  private static final String DATA_FILE = "contact.data";
  private static final String DATA_PATH = DATA_DIR + File.separator + DATA_FILE;

  // data 폴더의 contact.data 파일을 관리할 File 객체 선언
  private File dataDir = new File(DATA_DIR);
  private File dataFile = new File(DATA_PATH);

  private void initDatDir() {
    System.out.println("initDataDir()");

    if (dataDir.exists()) {
      return;
    }

    if (!dataDir.mkdir()) {
      System.out.println("디렉토리를 만들 수 없습니다.");
      return;
    }

    System.out.println("디렉토리를 만들었습니다.");
  }// end initDataDir()

  private void initDataFile() {
    System.out.println("initDataFile()");

    if (dataFile.exists()) {
      readDataFromFile();
      return;
    }

    try {
      boolean result = dataFile.createNewFile();
      if (!result) {
        System.out.println("파일을 만들 수 없습니다.");
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  private void writeDataToFile() {
    try (FileOutputStream out = new FileOutputStream(DATA_PATH);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ObjectOutputStream oout = new ObjectOutputStream(bout)) {

      oout.writeObject(list);
    } catch (Exception e) {
      System.out.println("파일을 쓰는 도중 에러가 발생했습니다.");
    }
  }// endwriteDataToFile()

  private void readDataFromFile() {
    if (dataFile.length() == 0) {
      System.out.println("기존의 데이터가 없습니다.");
      return;
    }

    try (FileInputStream in = new FileInputStream(DATA_PATH);
        BufferedInputStream bin = new BufferedInputStream(in);
        ObjectInputStream oin = new ObjectInputStream(bin)) {

      list = (ArrayList<ContactDTO>) oin.readObject();
      System.out.println("데이터를 불러오는데 성공했습니다.");
    } catch (Exception e) {
      System.out.println("파일을 읽는 도중 에러가 발생했습니다.");
    }
  } // end readDataFromFile

  public int getSize() {
    return list.size();
  }

  @Override
  public int insert(ContactDTO dto) {
    boolean result = list.add(dto);
    if (result) {
      writeDataToFile();
      return 1;
    }

    System.out.println("insert 도중 에러가 발생했습니다.");
    return 0;
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
    writeDataToFile();
    return 1;
  }

  @Override
  public int delete(int index) {
    list.remove(index);
    writeDataToFile();
    return 1;
  }
}

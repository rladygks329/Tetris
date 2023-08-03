package edu.java.contact05;

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

  // data 폴더의 contact.data 파일을 관리할 File 객체 선언
  private File dataFile;

  private void initDatDir() {
    File dataDir = new File(DATA_DIR);
    System.out.println("initDataDir()");
    System.out.println("폴더 경로 : " + dataDir.getPath());

    if (dataDir.exists()) {
      System.out.println("폴더를 확인했습니다.");
      return;
    }

    if (!dataDir.mkdirs()) {
      System.out.println("디렉토리를 만들 수 없습니다.");
      return;
    }

    System.out.println("디렉토리를 만들었습니다.");
  }// end initDataDir()

  private void initDataFile() {
    System.out.println("initDataFile()");
    String filePath = DATA_DIR + File.separator + DATA_FILE;
    dataFile = new File(filePath);

    // 파일이 있는 경우
    if (dataFile.exists()) {
      System.out.println("파일이 이미 존재합니다.");
      System.out.println("데이터 크기 : " + dataFile.length());
      readDataFromFile();
      return;
    }

    // 파일이 없는 경우
    try {
      boolean result = dataFile.createNewFile();
      if (!result) {
        System.out.println("파일을 만들 수 없습니다.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  } // end initDataFile()

  // list -> file
  private void writeDataToFile() {
    System.out.println("writeDataToFile");
    try (FileOutputStream out = new FileOutputStream(dataFile);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ObjectOutputStream oout = new ObjectOutputStream(bout)) {
      oout.writeObject(list);
    } catch (Exception e) {
      System.out.println("파일을 쓰는 도중 에러가 발생했습니다.");
    }
  }// end writeDataToFile()

  // file -> list
  private void readDataFromFile() {
    System.out.println("readDataFromFile()");
    if (dataFile.length() == 0) {
      System.out.println("기존의 데이터가 없습니다.");
      return;
    }

    try (FileInputStream in = new FileInputStream(dataFile);
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
    list.add(dto);
    writeDataToFile();
    return 1;
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

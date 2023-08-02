package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import edu.java.file04.MemberDTO;

public class FileMain07 {

  public static void main(String[] args) {
    System.out.println("데이터 파일을 읽어서 ArrayList의 내용 출력");
    ArrayList<MemberDTO> list = new ArrayList<>();

    try (InputStream in = new FileInputStream("temp/list.txt");
        BufferedInputStream bin = new BufferedInputStream(in);
        ObjectInputStream oin = new ObjectInputStream(bin)) {
      list = (ArrayList<MemberDTO>) oin.readObject();

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("다읽음");
    }

    for (MemberDTO m : list) {
      System.out.println(m);
    }
    System.out.println(list.size());
  } // end main()

} // end FileMain07

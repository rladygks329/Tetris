package edu.java.file05;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import edu.java.file04.MemberDTO;

// 프로그램 <== ObjectInputStream <== FileInputStream <== 파일(HDD)
public class FileMain05 {

  public static void main(String[] args) {
    InputStream in = null;
    ObjectInputStream oin = null;

    try {
      in = new FileInputStream("temp/member.txt");
      oin = new ObjectInputStream(in);

      while (true) {
        try {
          MemberDTO m = (MemberDTO) oin.readObject();
          System.out.println(m);
        } catch (EOFException e) {
          break;
        }
      }

      System.out.println("데이터 출력 완료");
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      try {
        if (oin != null) {
          oin.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }// end main()

} // end FileMain05

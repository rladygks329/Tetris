package edu.java.file04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일 (HDD)
public class FileMain04 {

  public static void main(String[] args) {
    OutputStream out = null;
    ObjectOutputStream oout = null;

    try {
      out = new FileOutputStream("temp/member.txt");
      oout = new ObjectOutputStream(out);

      MemberDTO m1 = new MemberDTO(1, "root1", "root1234");
      MemberDTO m2 = new MemberDTO(1, "root2", "root1235");
      MemberDTO m3 = new MemberDTO(1, "root3", "root1237");
      oout.writeObject(m1);
      oout.writeObject(m2);
      oout.writeObject(m3);

      System.out.println("파일 저장 성공!");
    } catch (Exception e) {
    } finally {
      try {
        // 리소스 (oout)를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
        // 그 리소스(oout)가 사용하고 있는 다른 리소스(out)들도 순차적으로 해제됨
        if (oout != null) {
          oout.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }// end main()

}// end FileMain04

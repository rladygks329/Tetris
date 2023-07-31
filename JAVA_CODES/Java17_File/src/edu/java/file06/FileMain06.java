package edu.java.file06;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import edu.java.file04.MemberDTO;

// 프로그램 ==> ObjectOutputStream ==> BufferedOutputStream ==>FileOutputStream ===> 파일(HDD)
public class FileMain06 {

  public static void main(String[] args) {
    System.out.println("ArrayList<Member> 객체를 파일에 저장하는 코드");

    OutputStream out = null;
    BufferedOutputStream bout = null;
    ObjectOutputStream oout = null;

    try {
      out = new FileOutputStream("temp/list.txt");
      bout = new BufferedOutputStream(out);
      oout = new ObjectOutputStream(bout);

      List<MemberDTO> list = new ArrayList<>();
      Long startTime = System.currentTimeMillis();
      for (int i = 0; i < 100000; i++) {
        String id = "member" + i;
        String pw = "pw" + i;
        MemberDTO m = new MemberDTO(i, id, pw);
        oout.writeObject(m);
        list.add(m);
      }
      oout.writeObject(list);
      Long endTime = System.currentTimeMillis();
      System.out.println("복사 경과 시간 : " + (endTime - startTime));
      System.out.println("데이터 저장 완료");
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (Exception e2) {
        System.out.println(e2);
      }

    }
  } // end main()

} // end FileMain06

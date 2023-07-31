package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMain03 {
  public static void main(String[] args) {

    InputStream in = null;
    OutputStream out = null;

    try {
      in = new FileInputStream("temp/big_text.txt");
      out = new FileOutputStream("temp/big_copy.txt");

      int data = 0;
      int byteCopied = 0;
      byte[] buffer = new byte[1024 * 1024]; // 1MB 공간
      // 1KB = 1024 Bytes
      // 1MB = 1024 * 1024 Bytes
      // 1GB = 1024 * 1024 * 1024 Bytes

      long startTime = System.currentTimeMillis();
      while (data != -1) {
        data = in.read(buffer);
        // read(byte[] b) :
        // 파일에서 읽은 데이터를 매개변수 배열 b에 저장
        // 실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1을 리턴
        System.out.println(data);
        if (data == -1) {
          break;
        }
        out.write(buffer);
        // write(byte[] b) :
        // - 매개변수 배열 b의 내용을 한 번에 파일에 씀
        byteCopied += data;
      }
      long endTime = System.currentTimeMillis();
      System.out.println("복사 경과 시간 : " + (endTime - startTime));
      System.out.println("복사된 바이트 : " + byteCopied);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        in.close();
        out.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }

  }// end main()
} // end FileMain03

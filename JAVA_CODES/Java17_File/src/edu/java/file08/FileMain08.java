package edu.java.file08;

import java.io.File;

// File 클래스 :
// |__파일(.txt, .doc, .mp4, .jpg, .png, ..) 객체와
// |__디렉토리(폴더) 객체를 다루기 위한 클래스

// File 클래스의 인스턴스 생성: new File() 세미클론
// 메모리(힙)에 File 클래스의 인스턴스를 생성한다는 의미
// 실제 하드디스크에 있는 물리적인 파일/폴더(디렉토리)를 생성하는 것은 아님
// 실제 파일/폴더를 만들기 위해서는 File 클래스의 메소드를 호출해야함

// 파일(디렉토리)의 경로 : 절대 경로, 상대 경로
// 절대 경로 : 루트(C:\, D:\)부터 파일(폴더)의 위치까지 전체 이름
// |__(예) C:\Users\goott3\Desktop\JAVA_CODES\Java17_File\src\edu\java\file08
// 상대 경로 : 현재 작업 디렉토리를 기준으로 파일(폴더)의 위치를 표시
// |__ (예) temp\test.txt
// |__ .:현재 디렉토리(폴더)
// |__ ..: 상위 디렉토리(폴더)

// 파일 구분자
// MS Windows - \ 사용
// Unix, Linux, Android, ... - / 사용
// 자바에는 File.separator 변수를 제공
public class FileMain08 {
  public static final String TEST_DIR1 = "C:\\test1";
  public static final String TEST_DIR2 = "test2";// t상대 경로
  public static final String TEST_DIR3 = "C:" + File.separator + "Study" + File.separator + "test3";

  public static void main(String[] args) {
    System.out.println(TEST_DIR1);
    System.out.println(TEST_DIR2);
    System.out.println(TEST_DIR3);

    File f = new File(TEST_DIR3); // 파일, 폴더를 다루기 위한 객체
    // exist() : 파일, 폴더가 존재하는지 (true), 아닌지(false)를 리턴
    if (f.exists()) { // 파일, 폴더가 있는 경우

    } else { // 파일, 폴더가 없는 경우
      System.out.println("폴더가 없습니다.");
      // mkdir() : 디렉토리를 생성하는 메소드, 성공하면 true, 실패하면 false
      // mkdirs() : 상위 디렉토리를 포함하여 생성하는 메소드.
      if (f.mkdirs()) {
        System.out.println("폴더 생성 성공");
      } else {
        System.out.println("폴더 생성 실패");
      }
    }

  }// end main()

} // end FileMain08

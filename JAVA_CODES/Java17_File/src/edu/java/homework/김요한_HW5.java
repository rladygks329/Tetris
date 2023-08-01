package edu.java.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 김요한_HW5 {
  private static final String FILENAME = "temp/students.txt";
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    List<Student> students = getStudent();

    save(students);
    students = load();
    for (Student s : students) {
      s.displayInfo();
    }

    sc.close();
  }// end main()

  public static List<Student> getStudent() {
    ArrayList<Student> result = new ArrayList<>();

    while (result.size() < 5) {
      try {
        System.out.println("이름>");
        String name = sc.next();
        System.out.println("수학 점수>");
        int eng = Integer.parseInt(sc.next());
        System.out.println("영어 점수>");
        int math = Integer.parseInt(sc.next());

        Student stu = new Student(name, eng, math);
        result.add(stu);

      } catch (Exception e) {
        System.out.println("올바른 값을 입력해주세요");
      }
    }

    return result;
  } // end getStudent()

  public static void save(List<Student> students) {
    try (OutputStream out = new FileOutputStream(FILENAME);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ObjectOutputStream oout = new ObjectOutputStream(out)) {
      oout.writeObject(students);
      System.out.println("데이터 저장 완료");
    } catch (Exception e) {
      System.out.println("데이터 저장 실패");
      e.printStackTrace();
    }
  }// end save()

  public static List<Student> load() {
    List<Student> result = null;

    try (InputStream in = new FileInputStream(FILENAME);
        BufferedInputStream bin = new BufferedInputStream(in);
        ObjectInputStream oin = new ObjectInputStream(bin)) {
      result = (List<Student>) oin.readObject();
    } catch (Exception e) {
      System.out.println("파일 불러오기 실패");
      e.printStackTrace();
    }

    return result;
  }// end load()
}// end 김요한_HW5

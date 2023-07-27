package edu.java.collections02;

import java.util.ArrayList;

class Student {
  private int stuNo;
  private String name;

  public Student() {}

  public Student(int stuNo, String name) {
    this.stuNo = stuNo;
    this.name = name;
  }

  public int getStuNo() {
    return stuNo;
  }

  public void setStuNo(int stuNo) {
    this.stuNo = stuNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", stuNo=" + stuNo + "]";
  }
} // end Student


public class ListMain02 {

  public static void main(String[] args) {
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(1);

    ArrayList<String> list2 = new ArrayList<>();
    list2.add("test");

    // student 타입을 지정한 ArrayList
    ArrayList<Student> list3 = new ArrayList<>();
    list3.add(new Student(1, "kim"));
    Student stu1 = new Student(2, "park");
    list3.add(stu1);
    for (int i = 0; i < list3.size(); i++) {
      System.out.println(list3.get(i));
    }

  }// end main()

} // end ListMain02

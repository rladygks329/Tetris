package edu.java.homework;

class 김요한04_1 {

  public static void main(String[] args) {
    String str = "사과:배:바나나:복숭아";

    String[] arr = str.split(":");
    StringBuffer sb = new StringBuffer();

    for (String s : arr) {
      sb.append(s);
    }
    System.out.println(sb); // sb.toString();
  } // end Main()
}

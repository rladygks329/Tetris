package edu.java.array09;

public class ArrayMain09 {

  public static void main(String[] args) {
    System.out.println("문자열 2차원 배열");
    String[] avengers = {"IronMan", "Hulk", "Thor", "CaptinAmerica"};
    String[] villain = {"Thanos", "Hydra", "RedSkull"};
    String[][] characters = {avengers, villain};

    for (String[] group : characters) {
      for (String name : group) {
        System.out.print(name + " ");
      }
      System.out.println();
    }
  } // end main()

} // end ArrayMain09

package edu.java.codeup;

import java.util.Scanner;

public class Main03 {

  public static void main(String[] args) {
    // code up 1099
    Scanner sc = new Scanner(System.in);

    int n = 10;
    int[][] graph = new int[n][n];
    int x = 1, y = 1;
    boolean found = false;

    // in
    for (int i = 0; i < n; i++) {
      String[] next_line = sc.nextLine().split(" ");
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(next_line[j]);
      }
    }

    found = (graph[1][1] == 2);
    graph[1][1] = 9;

    while (!found) {
      // 벽에 만나면 나가기
      if (x < 1 || y < 1 || x >= 9 || y >= 9) {
        break;
      }

      // 움직일 수 있는지 체크하기
      boolean movable = true;

      if (graph[x][y + 1] != 1) {
        found = (graph[x][y + 1] == 2);
        movable = false;
        graph[x][++y] = 9;
      } else if (graph[x + 1][y] != 1) {
        found = (graph[x + 1][y] == 2);
        movable = false;
        graph[++x][y] = 9;
      }
      // 움직일 수 없으면 나가기
      if (movable) {
        break;
      }
    }


    // out
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}

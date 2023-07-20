package edu.java.class04;

public class Solution {

  public int[] solution(int n, long left, long right) {
    int size = (int) (right - left) + 1;
    int[] answer = new int[size];

    for (int i = 0; i < size; i++) {
      int col = (int) ((i + left) / n) + 1;
      int row = (int) ((i + left) % n) + 1;
      answer[i] = col > row ? col : row;
    }
    return answer;
  }

}

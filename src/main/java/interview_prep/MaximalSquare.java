package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/is-subsequence/
 *
 * <p>Input: s = "abc", t = "ahbgdc" Output: true
 *
 * <p>Approach: Dynamic Programming
 *
 * <p>Runtime: O(S*T)
 */
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    if (matrix[0].length == 0) return 0;
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    int maxSquare = 1;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (matrix[i][j] == '1') {
          maxSquare = Math.max(BFS(matrix, i, j), maxSquare);
        }
      }
    }
    return maxSquare;
  }

  private int BFS(char[][] matrix, int row, int col) {
    int[] rowMove = {1, 0, 1};
    int[] colMove = {0, 1, 1};
    int level = 1;
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    LinkedList<int[]> queue = new LinkedList<>();
    queue.addLast(new int[] {row, col});
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int j = 0; j < queueSize; j++) {
        int[] currentCoord = queue.pollFirst();
        for (int i = 0; i < 3; i++) {
          int nextRow = currentCoord[0] + rowMove[i];
          int nextCol = currentCoord[1] + colMove[i];
          if (nextRow >= matrix.length || nextCol >= matrix[0].length) {
            return (int) Math.pow(level, 2);
          }
          if (matrix[nextRow][nextCol] == '0') {
            return (int) Math.pow(level, 2);
          } else {
            if (!visited[nextRow][nextCol]) {
              queue.addLast(new int[] {nextRow, nextCol});
              visited[nextRow][nextCol] = true;
            }
          }
        }
      }
      level++;
    }
    return (int) Math.pow(level, 2);
  }
}

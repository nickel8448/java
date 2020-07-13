package main.java.leetcode.DynamicProgramming;

/**
 * Problem: https://leetcode.com/problems/unique-paths/
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */

public class NumberOfWaysToTraverseAMatrix {
  public int uniquePaths(int rows, int cols) {
      if(rows <= 1 || cols <= 1)
          return 1;
    int[][] grid = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      grid[i][0] = 1;
    }
    for (int i = 0; i < cols; i++) {
      grid[0][i] = 1;
    }
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
      }
    }
    return grid[rows - 1][cols - 1];
  }
}

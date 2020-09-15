package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/number-of-islands/
 *
 * <p>Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"], ["1","1","0","0","0"],
 * ["0","0","0","0","0"] ] Output: 1
 *
 * <p>Approach: DFS
 *
 * <p>Runtime: O(M x N)
 */
public class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int area = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          area = Math.max(dfs(grid, visited, i, j), area);
        }
      }
    }
    return area;
  }

  private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
    if (row < 0
        || col < 0
        || row >= grid.length
        || col >= grid[0].length
        || grid[row][col] != 1
        || visited[row][col]) {
      return 0;
    }
    visited[row][col] = true;
    int area = 0;
    int[] rowMovement = {1, 0, -1, 0};
    int[] colMovement = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      area += dfs(grid, visited, row + rowMovement[i], col + colMovement[i]);
    }
    return area + 1;
  }
}

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
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];
    int islands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visitedGrid[i][j] && grid[i][j] == '1') {
          dfs(grid, visitedGrid, i, j);
          islands++;
        }
      }
    }
    return islands;
  }

  private void dfs(char[][] grid, boolean[][] visitedGrid, int row, int col) {
    visitedGrid[row][col] = true;
    int[] rowMovements = {1, 0, -1, 0};
    int[] colMovements = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      int rowMovement = row + colMovements[i];
      int colMovement = col + rowMovements[i];
      if (rowMovement >= 0
          && rowMovement < grid.length
          && colMovement >= 0
          && colMovement < grid[0].length) {
        if (!visitedGrid[rowMovement][colMovement] && grid[rowMovement][colMovement] == '1')
          dfs(grid, visitedGrid, rowMovement, colMovement);
      }
    }
  }
}

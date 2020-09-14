package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/minimum-path-sum/
 *
 * <p>Sample test: Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7
 *
 * <p>Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * <p>Approach: Dynamic Programming
 *
 * <p>Runtime: O(mn) Space complexity: O(mn)
 */
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] minSumGrid = new int[grid.length][grid[0].length];

    // fill the top row
    for (int i = 0; i < grid.length; i++) {
      if (i == 0) minSumGrid[i][0] = grid[i][0];
      else minSumGrid[i][0] = minSumGrid[i - 1][0] + grid[i][0];
    }

    // fill the first column
    for (int i = 0; i < grid[0].length; i++) {
      if (i == 0) minSumGrid[0][i] = grid[0][i];
      else minSumGrid[0][i] = minSumGrid[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        minSumGrid[i][j] = grid[i][j] + Math.min(minSumGrid[i - 1][j], minSumGrid[i][j - 1]);
      }
    }

    return minSumGrid[m - 1][n - 1];
  }
}

package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/unique-paths-ii/
 *
 * <p>Sample test: Input: [ [0,0,0], [0,1,0], [0,0,0] ] Output: 2 Explanation: There is one obstacle
 * in the middle of the 3x3 grid above. There are two ways to reach the bottom-right corner: 1.
 * Right -> Right -> Down -> Down 2. Down -> Down -> Right -> Right
 *
 * <p>Approach: Dynamic Programming
 *
 * <p>Runtime: O(MN)
 */
public class UniquePathII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[0][0] == 1) return 0;
    obstacleGrid[0][0] = 1;

    // fill the top row
    for (int i = 1; i < obstacleGrid[0].length; i++) {
      obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0);
    }

    // fill the first column
    for (int i = 1; i < obstacleGrid.length; i++) {
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0);
    }

    for (int i = 1; i < obstacleGrid.length; i++) {
      for (int j = 1; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        } else {
          obstacleGrid[i][j] = 0;
        }
      }
    }

    return obstacleGrid[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    UniquePathII u = new UniquePathII();
    System.out.println(u.uniquePathsWithObstacles(obstacleGrid));
  }
}

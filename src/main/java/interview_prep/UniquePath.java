package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/unique-paths/
 *
 * <p>Sample test: Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there are a
 * total of 3 ways to reach the bottom-right corner: 1. Right -> Right -> Down 2. Right -> Down ->
 * Right 3. Down -> Right -> Right
 *
 * <p>Approach: Dynamic programming - Keep a count of number of paths
 *
 * <p>Runtime: O(NM) Space complexity: O(NM)
 */
public class UniquePath {
  public int uniquePaths(int m, int n) {
    int[][] paths = new int[m][n];
    paths[0][0] = 0;
    for (int i = 0; i < paths.length; i++) {
      for (int j = 0; j < paths[i].length; j++) {
        if (i - 1 < 0 && j - 1 < 0) {
          paths[i][j] = paths[i][j] + paths[i][j] + 1;
        } else if (j - 1 < 0) {
          paths[i][j] = paths[i - 1][j] + paths[i][j];
        } else if (i - 1 < 0) {
          paths[i][j] = paths[i][j] + paths[i][j - 1];
        } else {
          paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
        }
      }
    }
    return paths[m - 1][n - 1];
  }
}

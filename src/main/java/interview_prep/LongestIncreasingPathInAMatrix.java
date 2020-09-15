package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * <p>Input: nums = [ [9,9,4], [6,6,8], [2,1,1] ] Output: 4 Explanation: The longest increasing path
 * is [1, 2, 6, 9].
 *
 * <p>Runtime: O(mn) Status: Time limit exceeded
 *
 * <p>Notebook status: Pending
 */
public class LongestIncreasingPathInAMatrix {
  public int longestIncreasingPath(int[][] matrix) {
    int longestPath = 0;
    int[][] cache = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int pathLength = dfs(matrix, i, j, cache);
        longestPath = Math.max(longestPath, pathLength);
      }
    }
    return longestPath;
  }

  private int dfs(int[][] matrix, int x, int y, int[][] cache) {
    if (cache[x][y] != 0) return cache[x][y];
    int[] rowMovement = {1, 0, -1, 0};
    int[] colMovement = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      int rowMove = x + rowMovement[i];
      int colMove = y + colMovement[i];
      if (rowMove >= 0 && colMove >= 0 && rowMove < matrix.length && colMove < matrix[0].length) {
        if (matrix[rowMove][colMove] > matrix[x][y]) {
          cache[x][y] = Math.max(cache[x][y], dfs(matrix, rowMove, colMove, cache));
        }
      }
    }
    return cache[x][y] += 1;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {7, 8, 9},
      {9, 7, 6},
      {7, 2, 3}
    };
    LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
    System.out.println(l.longestIncreasingPath(matrix));
  }
}

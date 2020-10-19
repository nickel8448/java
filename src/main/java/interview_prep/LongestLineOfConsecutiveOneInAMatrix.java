package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 *
 * <p>Runtime: Dynamic programming. Keep sliding the DP array
 */
public class LongestLineOfConsecutiveOneInAMatrix {
  public int longestLine(int[][] M) {
    if (M.length == 0) return 0;
    int n = M.length;
    int m = M[0].length;
    int[][] prevdp = new int[M[0].length][4];
    int[][] dp = new int[M[0].length][4];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[0].length; j++) {
        // M should be i - 1
        int currentElement = M[i][j];
        if (currentElement != 0) {
          if (j - 1 >= 0) {
            dp[j][0] = dp[j - 1][0] + 1; // horizontal
            dp[j][2] = prevdp[j - 1][2] + 1; // diagonal
          } else {
            dp[j][0] += 1;
            dp[j][2] += 1;
          }
          if (j + 1 < m) {
            dp[j][3] = prevdp[j + 1][3] + 1; // anti diagonal
          } else {
            dp[j][3] += 1;
          }
          dp[j][1] = prevdp[j][1] + 1; // vertical
        }
      }
      prevdp = dp;
      for (int j = 0; j < prevdp.length; j++) {
        for (int k = 0; k < prevdp[0].length; k++) {
          max = Math.max(prevdp[j][k], max);
        }
      }
      dp = new int[M[0].length][4];
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] m =
        new int[][] {
          {1, 1, 1, 1},
          {0, 1, 1, 0},
          {0, 0, 0, 1}
        };
    LongestLineOfConsecutiveOneInAMatrix l = new LongestLineOfConsecutiveOneInAMatrix();
    l.longestLine(m);
  }
}

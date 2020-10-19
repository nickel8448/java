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
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    int sourceLength = s.length(); // num rows in DP table
    int targetLength = t.length(); // num cols in DP table
    int[][] dp = new int[sourceLength + 1][targetLength + 1]; // Filled with 0
    for (int row = 1; row <= sourceLength; row++) {
      for (int col = 1; col <= targetLength; col++) {
        if (s.charAt(row - 1) == t.charAt(col - 1)) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else {
          dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        }
      }
    }
    if (dp[sourceLength][targetLength] == sourceLength) {
      return true;
    }
    return false;
  }
}

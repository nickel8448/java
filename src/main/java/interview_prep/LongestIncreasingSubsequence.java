package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * <p>Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing subsequence is
 * [2,3,7,101], therefore the length is 4.
 *
 * <p>Approach: Dynamic Programming Runtime: O(n^2)
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp, 1);
    // i is the right pointer and j is the left pointer
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < dp.length; i++) {
      result = Math.max(result, dp[i]);
    }
    return result;
  }
}

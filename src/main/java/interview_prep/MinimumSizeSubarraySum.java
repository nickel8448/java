package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * <p><pInput: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3] has the minimal
 * length under the problem constraint.
 *
 * <p>Runtime: O(S + T)
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int leftPointer = 0, rightPointer = 0, minLength = Integer.MAX_VALUE;
    int runningSum = 0;
    while (rightPointer < nums.length) {
      runningSum += nums[rightPointer];
      rightPointer++;
      while (runningSum >= s) {
        runningSum -= nums[leftPointer];
        minLength = Math.min(rightPointer - leftPointer, minLength);
        leftPointer++;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}

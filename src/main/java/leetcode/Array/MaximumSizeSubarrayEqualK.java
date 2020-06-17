package main.java.leetcode.Array;

import java.util.HashMap;

public class MaximumSizeSubarrayEqualK {
  /**
   * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
   *
   * @param nums
   * @param k
   * @return
   */
  public static int maxSubArrayLen(int[] nums, int k) {
    // sum -> index map
    HashMap<Integer, Integer> cumalativeSum = new HashMap<>();
    int maxLength = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) {
        if (i + 1 > maxLength) {
          maxLength = i + 1;
        }
      }
      int pendingSum = sum - k;
      if (!cumalativeSum.containsKey(sum)) {
        cumalativeSum.put(sum, i);
      }
      if (cumalativeSum.containsKey(pendingSum)) {
        int arrayLength = i - cumalativeSum.get(pendingSum);
        maxLength = Math.max(maxLength, arrayLength);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 0};
    System.out.println(maxSubArrayLen(nums, 1));
  }
}

package main.java.leetcode.Array;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    int left = 0, ans = Integer.MAX_VALUE, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= s) {
        ans = Math.min(i - left + 1, ans);
        sum -= nums[left];
        left++;
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}

package main.java.leetcode.Array;

public class MaxProductSubarray {
  public static int maxProduct(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    int maxProduct = 0;
    for (int i = 1; i < nums.length; i++) {
      dp[i + 1] = Math.max(nums[i], dp[i] * nums[i]);
      maxProduct = Math.max(maxProduct, dp[i + 1]);
    }
    return maxProduct;
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, -2, 4};
    int[] nums2 = {-2, 0, -1};
    System.out.println(maxProduct(nums2));
  }
}

package main.java.leetcode.Array;

public class MaximumSubarray {

  public static int maxSubArray(int[] nums) {
    return maxSubArray(nums, 0, nums.length - 1);
  }

  public static int maxSubArray(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }
    int mid = (left + right) / 2;
    int leftSum = maxSubArray(nums, left, mid);
    int rightSum = maxSubArray(nums, mid + 1, right);
    int crossSum = crossSum(nums, left, mid, right);
    int maxLeftAndRight = Math.max(leftSum, rightSum);
    return Math.max(maxLeftAndRight, crossSum);
  }

  public static int crossSum(int[] nums, int left, int mid, int right) {
    int leftSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= left; i--) {
      sum += nums[i];
      if (sum > leftSum) {
        leftSum = sum;
      }
    }

    int rightSum = Integer.MIN_VALUE;
    sum = 0;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      if (sum > rightSum) {
        rightSum = sum;
      }
    }
    return leftSum + rightSum;
  }

  /**
   * Solution using dynamic programming
   *
   * @param nums
   * @return
   */
  public static int maxSubArrayDP(int[] nums) {
    if (nums.length == 0) return Integer.MIN_VALUE;
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    int max = dp[1];
    for (int i = 1; i < nums.length; i++) {
      int currentSum = dp[i] + nums[i];
      int currentNum = nums[i];
      dp[i + 1] = Math.max(currentNum, currentSum);
      max = Math.max(max, dp[i + 1]);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArrayDP(arr));
  }
}

package main.java.leetcode.DivideAndConq;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    return 0;
  }

  public int maxSubArrayRec(int[] nums, int left, int right) {
    if (left == right) return nums[left];
    int mid = (left + right) / 2;
    int leftSum = maxSubArrayRec(nums, left, mid);
    int rightSum = maxSubArrayRec(nums, mid + 1, right);
    int crossSum = cross(nums, left, mid, right);
    return Math.max(leftSum, Math.max(rightSum, crossSum));
  }

  public int cross(int[] nums, int left, int mid, int right) {
    int leftMaxSum = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i > left; i--) {
      sum += nums[i];
      leftMaxSum = Math.max(leftMaxSum, sum);
    }
    int rightMaxSum = Integer.MIN_VALUE;
    sum = 0;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      rightMaxSum = Math.max(rightMaxSum, sum);
    }
    return leftMaxSum + rightMaxSum;
  }

  public static void main(String[] args) {}
}

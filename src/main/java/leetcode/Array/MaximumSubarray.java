package main.java.leetcode.Array;

public class MaximumSubarray {
    /**
     * Problem: https://leetcode.com/problems/maximum-subarray/
     * 3/4/2020
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        return subarray(nums, 0, nums.length - 1);
    }

    public static int subarray(int[] nums, int low, int high) {
        if(low == high) {
            return nums[low];
        }
        int mid = (low + high) / 2;
        int left = subarray(nums, low, mid);
        int right = subarray(nums, mid + 1, high);
        int crossSum = sum(nums, low, mid, high);
        return Math.max(crossSum, Math.max(left, right));
    }

    public static int sum(int[] nums, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int tempLeft = 0;
        for(int i = mid; i >= 0; i--) {
            tempLeft += nums[i];
            if(tempLeft > leftSum) leftSum = tempLeft;
        }

        int rightSum = Integer.MIN_VALUE;
        int tempRight = 0;
        for(int i = mid + 1; i <= high; i++) {
            tempRight += nums[i];
            if(tempRight > rightSum) rightSum = tempRight; 
        }

        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
}

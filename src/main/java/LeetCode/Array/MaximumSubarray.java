package main.java.LeetCode.Array;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public static int maxSubArray(int[] nums, int left, int right) {
        if(left == right) {
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
        for(int i = mid; i >= left; i--) {
            sum += nums[i];
            if(sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if(sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

}

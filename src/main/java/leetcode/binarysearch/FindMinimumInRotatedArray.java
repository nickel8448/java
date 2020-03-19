package main.java.leetcode.binarysearch;

public class FindMinimumInRotatedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int midPoint = left + (right - left) / 2;
            if(nums[midPoint] > nums[right])
                left = midPoint + 1;
            else
                right = midPoint;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

}

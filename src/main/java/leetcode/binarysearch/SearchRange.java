package main.java.leetcode.binarysearch;

import java.util.Arrays;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int midPoint = left + (right - left) / 2;
        while(left < right) {
            if(nums[midPoint] == target){
                break;
            }
            else if(nums[midPoint] > target) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
            midPoint = left + (right - left) / 2;
        }
        // Check the left
        int leftCounter = midPoint;
        while(nums[leftCounter] == target) {
            leftCounter--;
        }
        // Check the right
        int rightCounter = midPoint;
        while(nums[rightCounter] == target) {
            rightCounter++;
        }
        return new int[]{leftCounter, rightCounter};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}

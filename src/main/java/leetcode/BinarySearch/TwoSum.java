package main.java.leetcode.BinarySearch;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    output[0] = i + 1;
                    output[1] = j + 1;
                }
            }
        }
        return output;
    }

    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == target) {
                return new int[] {low + 1, high + 1};
            } else if(sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] input = {-1, 0};
        System.out.println(Arrays.toString(twoSumTwoPointers(input, -1)));
    }
}

package main.java.leetcode.Array;

public class MissingNumber {
    /**
     * Problem: https://leetcode.com/problems/missing-number/
     * 14/4/2020
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int numLength = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num >= 0 && num <= numLength && nums[num] >= 0) {
                nums[num] *= -1;
            }
        }
        int missing = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) missing = i;
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(missingNumber(nums));
    }
}

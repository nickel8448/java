package main.java.leetcode.Array;

import java.util.List;
import java.util.ArrayList;

public class NumbersDisappeared {
    /**
     * Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] countArray = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;            
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < countArray.length; i++) {
            if(countArray[i] == 0) result.add(i);
        }
        return result;
    }

    public static List<Integer> findDisappearedIntegersNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]) - 1;
            if(nums[abs] > 0) {
                nums[abs] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) result.add(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedIntegersNegative(nums));
    }
}

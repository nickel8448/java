package main.java.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        // Map contains index -> num
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            indexMap.put(i, nums[i]);
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> sortedMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sortedMap.put(nums[i], i);
        }
        String[] result = new String[nums.length];
        for(int i = 0; i < result.length; i++) {
            int element = indexMap.get(i);
            int elementIndexInSorted = sortedMap.get(element);
            if(elementIndexInSorted == nums.length - 1) {
                result[i] = "Gold Medal";
            } else if (elementIndexInSorted == nums.length - 2) {
                result[i] = "Silver Medal";
            } else if (elementIndexInSorted == nums.length - 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = Integer.toString(nums.length - elementIndexInSorted);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
}

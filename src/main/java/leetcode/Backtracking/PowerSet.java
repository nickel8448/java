package main.java.leetcode.Backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(output, new ArrayList<>(), nums, 0);
        return output;
    }

    public static void subsetsHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsHelper(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutedList = subsets(nums);
        for(int i = 0; i < permutedList.size(); i++) {
            System.out.println(permutedList.get(i));
        }
    }
}

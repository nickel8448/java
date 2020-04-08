package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        permuteHelper(outputList, new ArrayList<>(), nums);
        return outputList;
    }

    public static void permuteHelper(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(!temp.contains(nums[i])) {
                    temp.add(nums[i]);  // Choose
                    permuteHelper(list, temp, nums); // Explore
                    temp.remove(temp.size() - 1);  // Un choose
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutedList = permute(nums);
        for(int i = 0; i < permutedList.size(); i++) {
            System.out.println(permutedList.get(i));
        }
    }
}

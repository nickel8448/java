package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationArrayII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        permuteUniqueHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void permuteUniqueHelper(List<List<Integer>> result,
                                           ArrayList<Integer> runningList,
                                           int[] nums,
                                           boolean[] visited) {
        if(runningList.size() == nums.length) {
            result.add(new ArrayList<>(runningList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(visited[i])
                    continue;
                if(i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])
                    continue;
                runningList.add(nums[i]);
                visited[i] = true;
                permuteUniqueHelper(result, runningList, nums, visited);
                runningList.remove(runningList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}

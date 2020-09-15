package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/combination-sum/
 *
 * <p>Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3] ]
 *
 * <p>Approach: Backtracking
 *
 * <p>Runtime: O(N ^ T/m + 1) Because each input will create two branches
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, target, result, 0, new ArrayList<Integer>());
    return result;
  }

  private void backtrack(
      int[] nums, int target, List<List<Integer>> result, int index, List<Integer> runningList) {
    if (target == 0) {
      List<Integer> listToAdd = new ArrayList<>(runningList);
      result.add(listToAdd);
    } else if (target < 0) {
      return;
    } else {
      for (int i = index; i < nums.length; i++) {
        runningList.add(nums[i]);
        backtrack(nums, target - nums[i], result, i, runningList);
        runningList.remove(runningList.size() - 1);
      }
    }
  }
}

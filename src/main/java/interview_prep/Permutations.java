package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/permutations/
 *
 * <p>Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * <p>Approach: Backtracking
 *
 * <p>Runtime: O(N!) Because each input will create two branches
 */
public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int[] nums, List<Integer> runningList, List<List<Integer>> result) {
    if (nums.length == runningList.size()) {
      result.add(new ArrayList<Integer>(runningList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!runningList.contains(nums[i])) {
          runningList.add(nums[i]);
          backtrack(nums, runningList, result);
          runningList.remove(runningList.size() - 1);
        }
      }
    }
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/combination-sum-iii/
 *
 * <p>Input: k = 3, n = 7 Output: [[1,2,4]]
 *
 * <p>Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * <p>Approach: Backtracking
 *
 * <p>Runtime: O(9!-K/(9-K)!) Because each input will create two branches
 */
public class CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    sumHelper(nums, result, 0, k, n, new ArrayList<Integer>());
    return result;
  }

  private void sumHelper(
      int[] nums,
      List<List<Integer>> result,
      int index,
      int requiredLength,
      int requiredSum,
      List<Integer> runningList) {
    if (requiredLength == runningList.size() && requiredSum == 0) {
      result.add(new ArrayList<>(runningList));
    } else if (runningList.size() > requiredLength || requiredSum < 0) {
      return;
    } else {
      for (int i = index; i < nums.length; i++) {
        runningList.add(nums[i]);
        sumHelper(nums, result, i + 1, requiredLength, requiredSum - nums[i], runningList);
        runningList.remove(runningList.size() - 1);
      }
    }
  }
}

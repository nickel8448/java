package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/subsets/
 *
 * <p>Sample test: Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 * <p>Approach: Backtracking
 *
 * <p>Runtime: O(N x 2^N) Because each input will create two branches
 */
public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 0) return result;
    Set<List<Integer>> resultSet = new HashSet<>();
    backtrack(nums, result, resultSet, 0, new ArrayList<Integer>());
    return result;
  }

  private static void backtrack(
      int[] nums,
      List<List<Integer>> result,
      Set<List<Integer>> resultSet,
      int index,
      List<Integer> runningList) {
    if (!resultSet.contains(runningList)) {
      List<Integer> listToAdd = new ArrayList<>(runningList);
      result.add(listToAdd);
    }
    for (int i = index; i < nums.length; i++) {
      runningList.add(nums[i]);
      backtrack(nums, result, resultSet, i + 1, runningList);
      runningList.remove(runningList.size() - 1);
    }
  }
}

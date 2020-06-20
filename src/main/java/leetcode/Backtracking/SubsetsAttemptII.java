package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsAttemptII {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    result.add(new ArrayList<>());
    return result;
  }

  private static void backtrack(
      int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      result.add(new ArrayList<>(list));
      backtrack(nums, i + 1, list, result);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(subsets(new int[] {1, 2, 3}));
  }
}

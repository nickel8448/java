package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    subsetsHelper(result, new ArrayList<>(), 0, nums);
    return result;
  }

  public static void subsetsHelper(
      List<List<Integer>> result, List<Integer> runningList, int index, int[] nums) {
    result.add(new ArrayList<>(runningList));
    for (int i = index; i < nums.length; i++) {
      runningList.add(nums[i]);
      subsetsHelper(result, runningList, i + 1, nums);
      runningList.remove(runningList.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println(subsets(nums));
  }
}

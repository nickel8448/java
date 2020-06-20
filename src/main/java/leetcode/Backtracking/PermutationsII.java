package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<List<Integer>> listSet = new HashSet<>();
    dfs(result, new ArrayList<>(), nums, 0, listSet);
      System.out.println(result);
    return result;
  }

  private void dfs(
      List<List<Integer>> result,
      List<Integer> list,
      int[] nums,
      int index,
      HashSet<List<Integer>> listSet) {
    if (list.size() == nums.length) {
        listSet.add(new ArrayList<>(list));
        result.add(new ArrayList<>(list));
    } else {
      for (int i = 0; i < nums.length; i++) {
          list.add(nums[i]);
          dfs(result, list, nums, i + 1, listSet);
          list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    PermutationsII p = new PermutationsII();
    p.permuteUnique(new int[] {1, 2, 3});
  }
}

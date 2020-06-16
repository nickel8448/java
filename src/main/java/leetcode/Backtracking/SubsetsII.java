package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    dfs(result, new ArrayList<>(), 0, nums);
    return result;
  }

  private void dfs(List<List<Integer>> result, List<Integer> list, int index, int[] nums) {
      result.add(new ArrayList<>(list));
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) continue;  // not letting the branch to be created
      list.add(nums[i]);
      dfs(result, list, i + 1, nums);
      list.remove(list.size() - 1);
    }
  }

    public static void main(String[] args) {
        SubsetsII trial = new SubsetsII();
        System.out.println(trial.subsetsWithDup(new int[]{1, 2, 2}));
    }
}

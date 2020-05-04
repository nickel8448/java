package main.java.leetcode.Array;

import java.util.HashMap;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> complementMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (complementMap.containsKey(complement)) {
        return new int[] {complementMap.get(complement), i};
      } else {
        complementMap.put(complement, i);
      }
    }
    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    System.out.println(twoSum(nums, 9));
  }
}

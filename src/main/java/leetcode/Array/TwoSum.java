package main.java.leetcode.Array;

import java.util.HashMap;

public class TwoSum {
  /**
   * Function returns the index of elements which sum to the target
   *
   * @param nums
   * @param target
   * @return
   */
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

  /**
   * Returns the elements which equal to the target. If the element is not present, it returns an
   * empty integer Problem: https://www.algoexpert.io/questions/Two%20Number%20Sum
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoNumberSum(int[] nums, int target) {
    HashMap<Integer, Integer> complementMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (complementMap.containsKey(complement)) {
        return new int[] {nums[i], nums[complementMap.get(complement)]};
      } else {
        complementMap.put(nums[i], i);
      }
    }
    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {3, 5, -4, 8, 11, 1, -1, 6};
    System.out.println(twoNumberSum(nums, 10));
  }
}

package main.java.leetcode.Array;

import java.util.Arrays;

public class RemoveElement {
  /**
   * Problem: https://leetcode.com/problems/remove-element/
   *
   * @param nums
   * @param val
   * @return
   */
  public static int removeElement(int[] nums, int val) {
    int goodIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[goodIndex++] = nums[i];
      }
    }
    System.out.println(Arrays.toString(nums));
    return goodIndex;
  }

  public static void main(String[] args) {
    int[] nums = {3, 2, 2, 3};
    System.out.println(removeElement(nums, 3));
  }
}

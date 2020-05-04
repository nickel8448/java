package main.java.leetcode.Array;

import java.util.Arrays;

public class SortArrayByParityII {
  /**
   * Problem: https://leetcode.com/problems/sort-array-by-parity-ii/ Date: 26/03/2020
   *
   * @param nums
   * @return
   */
  public static int[] sortArrayByparityII(int[] nums) {
    int oddCounter = 1;
    for (int i = 0; i < nums.length; i += 2) {
      if (nums[i] % 2 == 1) {
        while (nums[oddCounter] % 2 == 1) oddCounter += 2;
        swapElement(nums, i, oddCounter);
      }
    }
    return nums;
  }

  public static void swapElement(int[] nums, int x, int y) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {846, 888, 627, 505};
    System.out.println(Arrays.toString(sortArrayByparityII(nums)));
  }
}

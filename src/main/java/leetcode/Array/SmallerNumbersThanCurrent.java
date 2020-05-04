package main.java.leetcode.Array;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
  public static int[] smallerNumbersThanCurrent(int[] nums) {
    if (nums.length == 0) return new int[1];
    int[] output = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          output[i]++;
        }
      }
    }
    return output;
  }

  public static void main(String[] args) {
    int[] input = {7, 7, 7, 7};
    System.out.println(Arrays.toString(smallerNumbersThanCurrent(input)));
  }
}

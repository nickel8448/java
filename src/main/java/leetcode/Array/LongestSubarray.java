package main.java.leetcode.Array;

public class LongestSubarray {
  public static int longestSubarray(int[] nums, int limit) {
    int longestArraySize = 1;
    int max = 1;
    int min = Integer.MAX_VALUE;
    for (int leftPointer = 0; leftPointer < nums.length; leftPointer++) {
      if (longestArraySize > nums.length - leftPointer) return longestArraySize;
      for (int rightPointer = leftPointer; rightPointer < nums.length; rightPointer++) {
        max = Math.max(nums[rightPointer], max);
        min = Math.min(nums[rightPointer], min);
        if (Math.abs(max - min) <= limit) {
          longestArraySize = Math.max(rightPointer - leftPointer + 1, longestArraySize);
        } else {
          max = 1;
          min = Integer.MAX_VALUE;
          break;
        }
      }
    }
    return longestArraySize;
  }

  public static void main(String[] args) {
    int[] input = {8, 2, 4, 7};
    System.out.println(longestSubarray(input, 4));
  }
}

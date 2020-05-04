package main.java.leetcode.Array;

public class IsMajorityElement {
  public boolean isMajorityElement(int[] nums, int target) {
    if (nums.length % 2 == 0) {
      if (nums[nums.length / 2] == target && nums[nums.length / 2 - 1] == target) return true;
    } else {
      if (nums[nums.length / 2] == target) return true;
    }
    return false;
  }
}

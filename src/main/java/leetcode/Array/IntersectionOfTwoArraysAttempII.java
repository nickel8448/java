package main.java.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysAttempII {
  /**
   * Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static int[] intersect(int[] nums1, int[] nums2) {
    // nums1 will always have longer length
    if (nums2.length > nums1.length) {
      intersect(nums2, nums1);
    }
    HashMap<Integer, Integer> intersectionMap = new HashMap<>();
    // putting the bigger array in the map
    for (int i = 0; i < nums1.length; i++) {
      intersectionMap.put(nums1[i], intersectionMap.getOrDefault(nums1[i], 0) + 1);
    }
    //
    int k = 0;
    for (int n : nums2) {
      int count = intersectionMap.getOrDefault(n, 0);
      if (count > 0) {
        nums1[k++] = n;
        intersectionMap.put(n, count - 1);
      }
    }
    return Arrays.copyOfRange(nums1, 0, k);
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    System.out.println(Arrays.toString(intersect(nums1, nums2)));
  }
}

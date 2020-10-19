package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/find-peak-element/
 *
 * <p>Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can return either
 * index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 * <p>Approach: Binary Search 1) We find the mid element. 1.1) If the element next to the mid
 * element is descending, the peak lies on the left side so we make right = mid 1.2) If the element
 * next to the mid element is ascending, the peak lies on the right side so we make left = mid + 1
 * 2) return left at the end
 *
 * <p>Runtime: O(logN)
 */
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}

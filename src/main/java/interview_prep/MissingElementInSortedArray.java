package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>Input: A = [4,7,9,10], K = 1 Output: 5 Explanation: The first missing number is 5.
 *
 * <p>Approach: 1) To figure out the number of elements missing in the array To find that -
 * nums[right] - nums[left] - (size of the array - 1) So from the input sample - (10 - 4) - (3) -
 * this means that there are 3 elements missing 2) If the required kth number is more than missing
 * values it will be post the last element value if (missing < k) return nums[nums.length - 1] + k -
 * missing
 *
 * <p>Runtime: O(2N) => O(N)
 */
public class MissingElementInSortedArray {

  /**
   * Returns the number of elements missing at a specific index
   *
   * @param nums
   * @param index
   * @return
   */
  private int missingAtIndex(int[] nums, int index) {
    return nums[index] - nums[0] - index;
  }

  public int missingElement(int[] nums, int k) {
    int n = nums.length;
    if (k > missingAtIndex(nums, n - 1)) {
      return (nums[n - 1] + k) - missingAtIndex(nums, n - 1);
    }
    int index = 1;
    while (missingAtIndex(nums, index) < k) index++;
    return nums[index - 1] + k - missingAtIndex(nums, index - 1);
  }
}

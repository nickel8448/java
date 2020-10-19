package main.java.interview_prep;

import java.util.*;

/**
 * Problem:
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * <p>Input: nums = [8,2,4,7], limit = 4 Output: 2 Explanation: All subarrays are: [8] with maximum
 * absolute diff |8-8| = 0 <= 4. [8,2] with maximum absolute diff |8-2| = 6 > 4. [8,2,4] with
 * maximum absolute diff |8-2| = 6 > 4. [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4. [2] with
 * maximum absolute diff |2-2| = 0 <= 4. [2,4] with maximum absolute diff |2-4| = 2 <= 4. [2,4,7]
 * with maximum absolute diff |2-7| = 5 > 4. [4] with maximum absolute diff |4-4| = 0 <= 4. [4,7]
 * with maximum absolute diff |4-7| = 3 <= 4. [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 *
 * <p>Approach: maxDeque and minDeque are used to store the max and min value in this particular
 * subarray which range is from the left pointer(l) to right pointer(r) By using max Deque. We
 * maintain list of max element candidates in monotonically decreasing order. Everytime the right
 * pointer reaches a new position, we need to dequeue the "tail" element who is smaller than the
 * nums[right].
 *
 * <p>Complexity - O(n)
 */
public class LongestContinuousSubarryWithDiff {
  public int longestSubarray(int[] nums, int limit) {
    LinkedList<Integer> maxDeque = new LinkedList<>();
    LinkedList<Integer> minDeque = new LinkedList<>();
    int result = 1;
    int leftPointer = 0;
    for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
      // Objective of the max Deque is that the number in front of the deque
      // is always the max number. We will remove all the numbers from the
      // list which < the new number
      while (!maxDeque.isEmpty() && maxDeque.peek() < nums[rightPointer]) {
        maxDeque.pollLast();
      }
      maxDeque.addLast(nums[rightPointer]);

      // Similar logic as the max deque
      while (!minDeque.isEmpty() && minDeque.peek() > nums[rightPointer]) {
        minDeque.pollLast();
      }
      minDeque.addLast(nums[rightPointer]);

      while (maxDeque.peek() - minDeque.peek() > limit) {
        if (maxDeque.peek() == nums[leftPointer]) maxDeque.pollFirst();
        if (minDeque.peek() == nums[leftPointer]) minDeque.pollFirst();
        leftPointer++; // shrik the left side
      }

      result = Math.max(result, rightPointer - leftPointer + 1);
    }
    return result;
  }
}

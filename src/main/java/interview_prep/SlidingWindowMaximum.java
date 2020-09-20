package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/sliding-window-maximum/
 *
 * <p>Input: Input: S = "aab" Output: "aba"
 *
 * <p>Runtime: O(26log26 N) TODO: Find how to calculate the number of elements in the output array
 * based on the window size and the input array size
 */
public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();

    // 1) Initially add the window to a deque
    // 2) Find the maximum from that window using Collections.max
    // 3) Next iteration, remove the element on the top and add an alement to
    // the end and if max element is removed use Collections.max otherwise
    // remove and add
    LinkedList<Integer> window = new LinkedList<>();

    // Initial addition to the window
    for (int i = 0; i < k; i++) {
      window.addLast(nums[i]);
    }
    int max = Collections.max(window);
    result.add(max);

    for (int i = 1; i < nums.length - k; i++) {
      int firstElementInWindow = window.pollFirst();
      int newNum = nums[i + k - 1];
      window.addLast(newNum);
      max = Collections.max(window);
      result.add(max);
    }

    int[] intResult = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      intResult[i] = result.get(i);
    }

    return intResult;
  }
}

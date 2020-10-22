package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/next-greater-element-i/
 *
 * <p>Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1] Explanation: For number 4 in the
 * first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3. For
 * number 2 in the first array, there is no next greater number for it in the second array, so
 * output -1.
 */
public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>(); // Map will contain the next greatest element
    Stack<Integer> stack = new Stack<>();
    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        // the stack pop is the previous number and the num is the next greater number
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      if (map.containsKey(nums1[i])) {
        result[i] = map.get(nums1[i]);
      } else {
        result[i] = -1;
      }
    }
    return result;
  }
}

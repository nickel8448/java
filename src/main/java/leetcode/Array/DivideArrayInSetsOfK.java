package main.java.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

// Input: nums = [1,2,3,3,4,4,5,6], k = 4
// Output: true
// Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

public class DivideArrayInSetsOfK {
  public boolean isPossibleDivide(int[] nums, int k) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
      frequencyMap.putIfAbsent(num, 0);
      frequencyMap.put(num, frequencyMap.get(num) + 1);
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (frequencyMap.get(nums[i]) >= 1) {
        for (int j = 0; j < k; j++) {
          int currentElement = nums[i] + j;
          if (frequencyMap.containsKey(currentElement) && frequencyMap.get(currentElement) <= 0) {
            return false;
          } else {
            frequencyMap.put(currentElement, frequencyMap.get(currentElement) - 1);
          }
        }
      }
    }
    for (Integer value : frequencyMap.values()) {
      if (value > 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
    DivideArrayInSetsOfK d = new DivideArrayInSetsOfK();
    System.out.println(d.isPossibleDivide(nums, 4));
  }
}

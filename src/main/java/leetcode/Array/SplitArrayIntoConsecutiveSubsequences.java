package main.java.leetcode.Array;

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences {
  public static boolean isPossible(int[] nums) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    HashMap<Integer, Integer> hypotheticalMap = new HashMap<>();
    // Adding the frequencies to the map
    for (int i = 0; i < nums.length; i++) {
      frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
    }
    for (int i = 0; i < nums.length; i++) {
      if (frequencyMap.get(nums[i]) == 0) continue;
      if (hypotheticalMap.getOrDefault(nums[i], 0) > 0) {
        // Check if the current number is wanted by an existing subsequence
        // Updating the hypotheticalMap
        hypotheticalMap.put(nums[i], hypotheticalMap.get(nums[i]) - 1);
        hypotheticalMap.put(nums[i] + 1, hypotheticalMap.getOrDefault(nums[i] + 1, 0) + 1);
        frequencyMap.put(nums[i], frequencyMap.get(nums[i]) - 1);
      } else {
        if (frequencyMap.get(nums[i]) > 0) {
          for (int j = 0; j < 3; j++) {
            int currentElement = nums[i] + j;
            if (frequencyMap.containsKey(currentElement) && frequencyMap.get(currentElement) > 0) {
              frequencyMap.put(currentElement, frequencyMap.get(currentElement) - 1);
            } else {
              return false;
            }
          }
          hypotheticalMap.put(nums[i] + 3, hypotheticalMap.getOrDefault(nums[i] + 3, 0) + 1);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, 4, 5, 6, 7, 8, 9, 10, 11};
    System.out.println(isPossible(nums));
  }
}

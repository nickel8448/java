package main.java.leetcode.Array;

import java.util.HashMap;

public class DegreeOfAnArray {

  private static class ElementProperties {
    int frequency;
    int startIndex;
    int endIndex;

    ElementProperties(int frequency, int startIndex, int endIndex) {
      this.frequency = frequency;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

  /**
   * https://leetcode.com/problems/degree-of-an-array/ Status: Completed
   *
   * @param nums
   * @return
   */
  public static int findShortestSubArray(int[] nums) {
    // 1. find the element with maximum frequency
    // frequency -> elements
    HashMap<Integer, ElementProperties> frequencyMap = new HashMap<>();
    int maxFrequency = 1;
    for (int i = 0; i < nums.length; i++) {
      if (!frequencyMap.containsKey(nums[i])) {
        frequencyMap.put(nums[i], new ElementProperties(1, i, i));
      } else {
        ElementProperties properties = frequencyMap.get(nums[i]);
        properties.endIndex = i;
        properties.frequency++;
        frequencyMap.put(nums[i], properties);
        maxFrequency = Math.max(properties.frequency, maxFrequency);
      }
    }
    int minSize = Integer.MAX_VALUE;
    for (Integer element : frequencyMap.keySet()) {
      ElementProperties properties = frequencyMap.get(element);
      if (properties.frequency == maxFrequency) {
        int length = properties.endIndex - properties.startIndex;
        if (length < minSize) minSize = length;
      }
    }
    return minSize == Integer.MAX_VALUE ? 1 : minSize + 1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 2, 3, 1, 4, 2};
    System.out.println(findShortestSubArray(nums));
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Input: s = "eceba", k = 2 Output: 3 Explanation: T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctChars {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    int leftPointer = 0, rightPointer = 0, maxLength = 0;
    while (rightPointer < s.length()) {
      char rightChar = s.charAt(rightPointer);
      frequencyMap.put(rightChar, rightPointer);
      rightPointer++;
      if (frequencyMap.size() == k + 1) {
        int leftMostIndex = Collections.min(frequencyMap.values());
        frequencyMap.remove(s.charAt(leftMostIndex));
        leftPointer = leftMostIndex + 1;
      }
      maxLength = Math.max(maxLength, rightPointer - leftPointer);
    }
    return maxLength;
  }
}

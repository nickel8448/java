package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * <p>Approach: Sliding window The window moves with each character Status: Not completed
 *
 * <p>Runtime: O(2N) => O(N)
 */
public class MinimumWindowSubsequence {
  public String minWindow(String S, String T) {
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : T.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }
    String result = "";
    int stringLength = Integer.MAX_VALUE;
    int leftPointer = 0, rightPointer = 0, counter = frequencyMap.size();
    while (rightPointer < S.length()) {
      char rightChar = S.charAt(rightPointer);
      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.get(rightPointer) - 1);
        if (frequencyMap.get(rightChar) == 0) counter--;
      }
      rightPointer++;
      while (counter == 0) {
        char leftChar = S.charAt(leftPointer);
        if (frequencyMap.containsKey(leftChar)) {
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
          if (frequencyMap.get(leftChar) > 0) {
            counter++;
          }
        }
        if (rightPointer - leftPointer < stringLength) {
          result = S.substring(leftPointer, rightPointer);
          stringLength = result.length();
        }
        leftPointer++;
      }
    }
    return result;
  }
}

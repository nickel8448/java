package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/minimum-window-substring/
 *
 * <p>Input: Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 *
 * <p>Runtime: O(S + T)
 */
public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    String output = new String();
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }
    int leftPointer = 0,
        rightPointer = 0,
        minLength = Integer.MAX_VALUE,
        counter = frequencyMap.size();
    while (rightPointer < s.length()) {
      char rightChar = s.charAt(rightPointer);
      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
        if (frequencyMap.get(rightChar) == 0) counter--;
      }
      rightPointer++;
      while (counter == 0) {
        char leftChar = s.charAt(leftPointer);
        if (frequencyMap.containsKey(leftChar)) {
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
          if (frequencyMap.get(leftChar) > 0) counter++;
        }
        if (rightPointer - leftPointer < minLength) {
          minLength = rightPointer - leftPointer;
          output = s.substring(leftPointer, rightPointer);
        }
        leftPointer++;
      }
    }

    return output;
  }
}

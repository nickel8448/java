package main.java.interview_prep;

import java.util.*;

/**
 * problem: https://leetcode.com/problems/permutation-in-string/ runtime: o(s1 length + s2 length)
 */
public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : s1.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }
    int leftPointer = 0, rightPointer = 0, counter = frequencyMap.size();
    while (rightPointer < s2.length()) {
      char rightChar = s2.charAt(rightPointer);
      if (frequencyMap.containsKey(rightChar)) {
        frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
        if (frequencyMap.get(rightChar) == 0) counter--;
      }
      rightPointer++;
      while (counter == 0) {
        char leftChar = s2.charAt(leftPointer);
        if (frequencyMap.containsKey(leftChar)) {
          frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
          if (frequencyMap.get(leftChar) > 0) counter++;
        }
        if (rightPointer - leftPointer == s1.length()) return true;
        leftPointer++;
      }
    }
    return false;
  }
}

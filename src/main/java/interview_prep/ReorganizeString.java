package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/reorganize-string/
 *
 * <p>Input: Input: S = "aab" Output: "aba"
 *
 * <p>Runtime: O(26log26 N)
 */
public class ReorganizeString {
  public String reorganizeString(String s) {
    if (s.length() == 1) return s;
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    s = new String(chars);
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1); // a -> 2, b -> 1
    }
    int n = s.length() - 1; // n = 2
    Character prev = null;
    StringBuilder output = new StringBuilder();
    while (n != 0) {
      if (prev == null) {
        prev = s.charAt(0); // prev = 'a'
        output.append(s.charAt(0)); // output = 'a'
        frequencyMap.put(s.charAt(0), frequencyMap.get(s.charAt(0)) - 1); // a -> 1, b -> 1
      } else {
        boolean charAdded = false;
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) != prev && frequencyMap.get(s.charAt(i)) >= 1) {
            output.append(s.charAt(i)); // output = 'aba'
            frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) - 1); // a -> 0, b -> 0
            charAdded = true;
            prev = s.charAt(i); // prev = 'a'
            break;
          }
        }
        if (charAdded) {
          n--; // n = 0
        } else {
          return "";
        }
      }
    }
    return output.toString();
  }
}

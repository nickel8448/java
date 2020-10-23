package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/repeated-substring-pattern/
 *
 * <p>Input: "abcabcabcabc" Output: True Explanation: It's the substring "abc" four times. (And the
 * substring "abcabc" twice.)
 *
 * <p>Approach:
 *
 * <p>Runtime: O(N)
 */
public class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String s) {
    if (s.length() == 0 || s.length() == 1) return false;
    String pattern = findPattern(s);
    for (int i = 0; i < s.length(); i += pattern.length()) {
      String currentPattern = s.substring(i, pattern.length());
      if (!pattern.equals(currentPattern)) {
        return false;
      }
    }
    return true;
  }

  // abaaba
  public boolean repeatedSubstringPatternBruteForce(String s) {
    if (s.length() == 0 || s.length() == 1) return false;
    for (int i = 1; i <= s.length() / 2; i++) {
      String pattern = s.substring(0, i); // ab
      boolean repeated = true;
      int rightPointer = 0;
      for (int j = i; j + i <= s.length(); j += i) { // j = 2  i = 2
        rightPointer = i + j;
        String currentPattern = s.substring(j, j + i); // b
        if (!pattern.equals(currentPattern)) {
          repeated = false;
        }
        if (!repeated) {
          break;
        }
      }
      if (repeated && rightPointer == s.length()) {
        return true;
      }
    }
    return false;
  }

  private String findPattern(String s) {
    StringBuilder pattern = new StringBuilder();
    pattern.append(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      if (currentChar != pattern.charAt(0)) {
        pattern.append(currentChar);
      } else {
        return pattern.toString();
      }
    }
    return pattern.toString();
  }
}

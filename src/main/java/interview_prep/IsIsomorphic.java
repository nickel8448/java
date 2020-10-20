package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>Input: s = "paper", t = "title" Output: true
 *
 * <p>Runtime: O(N)
 */
public class IsIsomorphic {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    HashMap<Character, Character> charMapST = new HashMap<>();
    HashMap<Character, Character> charMapTS = new HashMap<>();
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      char currentCharS = sChars[i];
      char currentCharT = tChars[i];
      if (charMapST.containsKey(currentCharS)) {
        if (charMapST.get(currentCharS) != currentCharT) {
          return false;
        }
      } else {
        charMapST.put(currentCharS, currentCharT);
      }
      if (charMapTS.containsKey(currentCharT)) {
        if (charMapTS.get(currentCharT) != currentCharS) {
          return false;
        }
      } else {
        charMapTS.put(currentCharT, currentCharS);
      }
    }
    return true;
  }
}

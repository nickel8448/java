package main.java.leetcode.String;

import java.util.HashMap;

public class MinWindowSubstring {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    int minLength = s.length() + 1, minLeft = 0, minRight = 0;
    int left = 0;
    int right = 0;
    int formed = 0;
    int required = tMap.size();
    HashMap<Character, Integer> windowChars = new HashMap<>();
    while (right < s.length()) {
      char c = s.charAt(right);
      windowChars.put(c, windowChars.getOrDefault(c, 0) + 1);
      if (tMap.containsKey(c) && tMap.get(c).intValue() == windowChars.get(c).intValue()) {
        formed++;
      }
      while (required == formed) {
        if (right - left < minLength) {
          minLength = right - left;
          minLeft = left;
          minRight = right;
        }
        char leftChar = s.charAt(left);
        windowChars.put(leftChar, windowChars.get(leftChar) - 1);
        if (tMap.containsKey(leftChar)
            && windowChars.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
          formed--;
        }
        left++;
      }
      right++;
    }
    return minLength > s.length() ? "" : s.substring(minLeft, minRight);
  }
}

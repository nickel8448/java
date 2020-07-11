package main.java.leetcode.String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int left = 0, right = 0, min = Integer.MIN_VALUE;
    while (left < s.length() && right < s.length()) {
      char c = s.charAt(right);
      if (!set.contains(c)) {
        right++;
        set.add(c);
        min = Math.max(min, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return min;
  }
}

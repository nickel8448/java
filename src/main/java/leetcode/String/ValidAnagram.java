package main.java.leetcode.String;

// Problem:
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/

import java.util.Arrays;

public class ValidAnagram {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] tracker = new int[26];
    Arrays.fill(tracker, 0);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int charIndex = c - 'a';
      ++tracker[charIndex];
    }
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      int charIndex = c - 'a';
      if (--tracker[charIndex] < 0) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "a";
    String t = "a";
    String a = "rat";
    String b = "car";
    System.out.println(isAnagram(s, t));
    System.out.println(isAnagram(a, b));
  }
}

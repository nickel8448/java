package main.java.leetcode.String;

import java.util.HashSet;

// Problem: https://leetcode.com/problems/shortest-way-to-form-string/
// Status: Solved

public class ShortestWayToFormString {
  public int shortestWay(String source, String target) {
    HashSet<Character> sourceSet = new HashSet<>();
    for (Character c : source.toCharArray()) {
      sourceSet.add(c);
    }
    for (Character c : target.toCharArray()) {
      if (sourceSet.add(c)) {
        return -1;
  }
    }
    int i = 0;
    int j = target.length();
    int count = 0;
    while (i < j) {
      for (int k = 0; k < source.length() && i < target.length(); k++) {
        char sourceChar = source.charAt(k);
        char targetChar = target.charAt(i);
        if (sourceChar == targetChar) {
          i++;
        }
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    ShortestWayToFormString s = new ShortestWayToFormString();
    System.out.println(s.shortestWay("abc", "abcbc"));
  }
}

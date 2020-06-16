package main.java.leetcode.String;

import java.util.HashMap;

public class IsomorphicString {
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> stringOneMap = new HashMap<>();
    HashMap<Character, Character> stringTwoMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      stringOneMap.putIfAbsent(s.charAt(i), t.charAt(i));
      stringTwoMap.putIfAbsent(t.charAt(i), s.charAt(i));
      if (stringOneMap.get(s.charAt(i)) != t.charAt(i)
          || stringTwoMap.get(t.charAt(i)) != s.charAt(i)) return false;
    }
    return true;
  }
}

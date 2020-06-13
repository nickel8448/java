package main.java.leetcode.String;


public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) i++;
      j++;
    }
    return i == s.length();
  }

  public boolean isSubsequenceUsingIndexOf(String s, String t) {
    int current = 0;
    for(int i = 0; i < s.length(); i++) {
        int index = t.indexOf(s.charAt(i), current);
        if(index == -1)
            return false;
        current = index;
    }
    return true;
  }
}

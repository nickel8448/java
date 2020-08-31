package main.java.leetcode.SlidingWindow;

public class MinimumWindowSubsequence {
    /**
     * Problem: https://leetcode.com/problems/minimum-window-subsequence/
     * Solved the solution using sliding window but a DP solution is required
     * @param s
     * @param t
     * @return
     */
  public String minWindow(String s, String t) {
    if (t.length() == 1) {
      int index = s.indexOf(t.charAt(0));
      return index == -1 ? "" : s.substring(index, index + 1);
    }
    int minLength = Integer.MAX_VALUE;
    String result = "";
    for (int leftPointer = 0; leftPointer < s.length(); leftPointer++) {
      char currentChar = s.charAt(leftPointer);
      if (currentChar == t.charAt(0)) {
        int counter = 1;
        int rightPointer = leftPointer + 1;
        while (rightPointer < s.length()) {
          if (counter < t.length() && s.charAt(rightPointer) == t.charAt(counter)) {
            counter++;
            if (counter == t.length()) {
              int currentLength = rightPointer - leftPointer;
              if (currentLength < minLength) {
                result = s.substring(leftPointer, rightPointer + 1);
                minLength = currentLength;
              }
              break;
            }
          }
          rightPointer++;
        }
      }
    }
    return result;
  }
}

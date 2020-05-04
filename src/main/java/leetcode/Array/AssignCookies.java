package main.java.leetcode.Array;

import java.util.Arrays;

public class AssignCookies {
  /**
   * Problem: https://leetcode.com/problems/assign-cookies/
   *
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren(int[] g, int[] s) {
    int contentChildren = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int cookieCounter = s.length - 1;
    for (int i = g.length - 1; i >= 0; i--) {
      if (s[cookieCounter] >= g[i]) {
        cookieCounter--;
        contentChildren++;
      }
      if (cookieCounter < 0) break;
    }
    return contentChildren;
  }
}

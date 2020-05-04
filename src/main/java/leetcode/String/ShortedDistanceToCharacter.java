package main.java.leetcode.String;

import java.util.Arrays;

public class ShortedDistanceToCharacter {
  /**
   * Problem: https://leetcode.com/problems/shortest-distance-to-a-character/ 27/3/2020
   *
   * @param str
   * @param c
   * @return
   */
  public static int[] shortestToChar(String str, char c) {
    int[] output = new int[str.length()];
    // go through from the left
    int currentLocation = Integer.MIN_VALUE / 2;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == c) currentLocation = i;
      output[i] = Math.abs(currentLocation - i);
    }

    currentLocation = Integer.MAX_VALUE / 2;
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == c) currentLocation = i;
      output[i] = Math.min(output[i], Math.abs(currentLocation - i));
    }
    // go through from the right
    return output;
  }

  public static void main(String[] args) {
    String str = "loveleetcode";
    char c = 'e';
    System.out.println(Arrays.toString(shortestToChar(str, c)));
  }
}

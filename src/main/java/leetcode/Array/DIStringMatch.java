package main.java.leetcode.Array;

import java.util.Arrays;

public class DIStringMatch {
  public static int[] diStringMatch(String S) {
    int incrementCounter = 0;
    int decrementCounter = S.length();
    int[] output = new int[S.length() + 1];
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == 'I')
        output[i] = incrementCounter++;
      else
        output[i] = decrementCounter--;
    }
    output[S.length()] = decrementCounter;
    return output;
  }

  public static void main(String[] args) {
    String S = "I";
    System.out.println(Arrays.toString(diStringMatch(S)));
  }
}

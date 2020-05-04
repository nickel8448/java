package main.java.leetcode.String;

// Problem:
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/

import java.util.Arrays;

public class ReverseString {
  public static void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; ++i) {
      char temp = s[i];
      s[i] = s[s.length - i - 1];
      s[s.length - i - 1] = temp;
    }
  }

  public static void main(String[] args) {
    char[] s = {'h', 'e', 'l', 'l', 'o'};
    reverseString(s);
    System.out.println(Arrays.toString(s));
  }
}

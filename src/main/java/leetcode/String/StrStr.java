package main.java.leetcode.String;

// Problem:
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

public class StrStr {

  public static int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || needle.isEmpty()) return 0;
    int subStringLength = haystack.length() - needle.length();
    for (int i = 0; i <= subStringLength; i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    String haystack = "a";
    String needle = "a";
    System.out.println(strStr(haystack, needle));
    System.out.println(haystack.indexOf(needle));
  }
}

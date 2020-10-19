package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-absolute-file-path/
 *
 * <p>Approach: 1) Split the string by "\n" into tokens of String[] 2) Go through each word in the
 * String[] 3) Count the level of a file/directory by the number of /ts in it. Use
 * s.replaceAll("\t") to replace them and count the difference in length 4) rest in the algo
 */
public class LongestAbsoluteFilePath {
  public int lengthLongestPath(String input) {
    String[] tokens = input.split("\n");
    Stack<Integer> lengthStack = new Stack<>();
    int result = 0, currentLength = 0;
    for (String s : tokens) {
      int level = countLevel(s);
      while (lengthStack.size() > level) {
        currentLength -= lengthStack.pop();
      }
      int length = s.replaceAll("\t", "").length() + 1;
      currentLength += length;
      if (s.contains(".")) {
        result = Math.max(currentLength - 1, result);
      }
      lengthStack.add(length);
    }
    return result;
  }

  private int countLevel(String s) {
    String current = s.replaceAll("\t", "");
    return s.length() - current.length();
  }

  public static void main(String[] args) {
    String input =
        "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
    System.out.println(l.lengthLongestPath(input));
  }
}

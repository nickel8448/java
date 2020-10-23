package main.java.interview_prep;

/** Problem: https://leetcode.com/problems/repeated-string-match/ */
public class RepeatedStringMatch {
  public int repeatedStringMatch(String A, String B) {
    int result = 1;
    StringBuilder newString = new StringBuilder(A);
    while (newString.length() < B.length()) {
      newString.append(A);
      result++;
    }
    if (newString.indexOf(B) != -1) return result;
    if (newString.append(A).indexOf(B) != -1) return result + 1;
    return -1;
  }
}

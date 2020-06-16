package main.java.leetcode.String;

public class RotateString {
  public boolean rotateString(String A, String B) {
    for (int i = 0; i < A.length(); i++) {
      A = getRotatedString(A);
      if (A.equals(B)) return true;
    }
    return false;
  }

  private String getRotatedString(String str) {
    return str.substring(1, str.length()) + str.substring(0, 1);
  }

  public static void main(String[] args) {
    String A = "abcde";
    String B = "abced";
    System.out.println(new RotateString().rotateString(A, B));
  }
}

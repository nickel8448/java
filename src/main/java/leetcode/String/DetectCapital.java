package main.java.leetcode.String;

public class DetectCapital {
  /**
   * Problem: https://leetcode.com/problems/detect-capital/
   *
   * @param word
   * @return
   */
  public static boolean detectCapitalUse(String word) {
    boolean isFirstLetterUppercase = false;
    int numUppercase = 0;
    for (int i = 0; i < word.length(); i++) {
      if (i == 0) {
        if (Character.isUpperCase(word.charAt(i))) {
          isFirstLetterUppercase = true;
          numUppercase++;
        }
      } else {
        if (Character.isUpperCase(word.charAt(i))) {
          numUppercase++;
        }
      }
    }
    // there are multiple upper case letters
    if (isFirstLetterUppercase && numUppercase == 1) return true;
    else if (isFirstLetterUppercase && numUppercase < word.length()) return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(detectCapitalUse("USA"));
    System.out.println(detectCapitalUse("FlaG"));
    System.out.println(detectCapitalUse("A"));
    System.out.println(detectCapitalUse("Google"));
  }
}

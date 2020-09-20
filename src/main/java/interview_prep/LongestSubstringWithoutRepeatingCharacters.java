package main.java.interview_prep;


/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * <p>Approach: Sliding window The window moves with each character
 *
 * <p>Runtime: O(2N) => O(N)
 */
public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int leftPointer = 0;
    int rightPointer = 0;
    int longestLength = 0;
    while (leftPointer < s.length() && rightPointer < s.length()) {
      if (!charSet.contains(s.charAt(rightPointer))) {
        charSet.add(s.charAt(rightPointer));
        rightPointer++;
        longestLength = Math.max(rightPointer - leftPointer, longestLength);
      } else {
        charSet.remove(s.charAt(leftPointer));
        leftPointer++;
      }
    }
    return longestLength;
  }
}

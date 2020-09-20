package main.java.interview_prep;

import java.util.HashMap;
import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * <p>Input: "eceba" Output: 3 Explanation: t is "ece" which its length is 3. Input: "ccaabbb"
 * Output: 5 Explanation: t is "aabbb" which its length is 5.
 *
 * <p>Approach: 1) Brute Force 2) Sliding window and not two pointer
 *
 * <p>Runtime:
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

  public int lengthOfLongestSubstringTwoDistinctBruteForce(String s) {
    HashSet<Character> charSet = new HashSet<>();
    int leftPointer = 0, rightPointer = 0, maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      charSet.add(s.charAt(i));
      for (int j = i + 1; j < s.length(); j++) {
        charSet.add(s.charAt(j));
        if (charSet.size() > 2) {
          charSet.clear();
          i = j + 1;
          break;
        } else {
          maxLength = Math.max(j - i + 1, maxLength);
        }
      }
    }
    return maxLength;
  }

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.length() < 3) return s.length();
    HashMap<Character, Integer> indexMap = new HashMap<>();
    int leftPointer = 0, rightPointer = 0, maxLength = 0;
    while (rightPointer < s.length()) {
      if (indexMap.size() < 3) {
        indexMap.put(s.charAt(rightPointer), rightPointer);
        rightPointer++;
      }
      // The sliding window contains 3 letters
      if (indexMap.size() == 3) {
        int indexToDelete = Collections.min(indexMap.values());
        indexMap.remove(s.charAt(indexToDelete));
        leftPointer = indexToDelete + 1;
      }

      maxLength = Math.max(maxLength, rightPointer - leftPointer);
    }
    return maxLength;
  }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
        System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}

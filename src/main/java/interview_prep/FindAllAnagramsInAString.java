package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * <p>Input: s: "cbaebabacd" p: "abc"
 *
 * <p>Output: [0, 6]
 *
 * <p>Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The
 * substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * <p>Approach: Sliding window approach
 *
 * <p>Runtime:
 */
public class FindAllAnagramsInAString {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    HashMap<Character, Integer> frequencyMapForP = new HashMap<>();
    for (char c : p.toCharArray()) {
      frequencyMapForP.put(c, frequencyMapForP.getOrDefault(c, 0) + 1);
    }
    int counter = frequencyMapForP.size();
    int leftPointer = 0, rightPointer = 0;
    while (rightPointer < s.length()) {
      char currentChar = s.charAt(rightPointer);
      if (frequencyMapForP.containsKey(currentChar)) {
        frequencyMapForP.put(currentChar, frequencyMapForP.get(currentChar) - 1);
        if (frequencyMapForP.get(currentChar) == 0) counter--;
      }
      rightPointer++;
      while (counter == 0) {
        char leftChar = s.charAt(leftPointer);
        if (frequencyMapForP.containsKey(leftChar)) {
          frequencyMapForP.put(leftChar, frequencyMapForP.get(leftChar) + 1);
          if (frequencyMapForP.get(leftChar) > 0) counter++;
        }
        // This check is done so that if an anagram is found but it is disjointed
        // in that case we check this to make sure it is not disjointed
        if (rightPointer - leftPointer == p.length()) {
          result.add(leftPointer);
        }
        leftPointer++;
      }
    }
    return result;
  }
}

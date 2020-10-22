package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * <p>Input: "{a,b}c{d,e}f" Output: ["acdf","acef","bcdf","bcef"]
 *
 * <p>Input: "abcd" Output: ["abcd"]
 *
 * <p>Input: "a{b,c}"
 *
 * <p>Runtime: O(N)
 */
public class BraceExpansion {
  public String[] expand(String S) {
    List<String> result = new ArrayList<>();
    DFS(S, result, 0, new StringBuilder());
    String[] resultArray = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArray[i] = result.get(i);
    }
    return resultArray;
  }

  private void DFS(String S, List<String> result, int index, StringBuilder runningString) {
    if (index == S.length()) {
      if (runningString.length() > 0) result.add(runningString.toString());
      return;
    }
    if (S.charAt(index) == '{') {
      int endIndex = index + 1;
      List<Character> innerList = new ArrayList<>();
      while (endIndex < S.length() && S.charAt(endIndex) != '}') {
        if (Character.isLetter(S.charAt(endIndex))) {
          innerList.add(S.charAt(endIndex));
        }
        endIndex++;
      }
      Collections.sort(innerList);
      for (int i = 0; i < innerList.size(); i++) {
        runningString.append(innerList.get(i));
        DFS(S, result, endIndex + 1, runningString);
        runningString.setLength(runningString.length() - 1);
      }
    } else if (Character.isLetter(S.charAt(index))) {
      DFS(S, result, index + 1, runningString.append(S.charAt(index)));
    }
  }
}

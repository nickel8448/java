package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/brace-expansion/
 *
 * <p>Input: "{a,b}c{d,e}f" Output: ["acdf","acef","bcdf","bcef"]
 *
 * <p>Input: "abcd" Output: ["abcd"]
 *
 * <p>Complexity - O(n)
 */
public class BraceExpansion {
  public String[] expand(String S) {
    List<String> stringList = getListFromString(S);
    if (stringList.size() == 1) {
      return getArrayFromList(stringList);
    }
    List<String> resultList = new LinkedList<>();
    backtrack(stringList, resultList, 0, new StringBuilder());
    // TODO: Sorting is pending
      Collections.sort(resultList);
    return getArrayFromList(resultList);
  }

  private void backtrack(List<String> stringList, List<String> resultList, int wordIndex, StringBuilder currentString) {
    if (stringList.size() == currentString.length()) {
      resultList.add(currentString.toString());
    }
    if (wordIndex < stringList.size()) {
      String word = stringList.get(wordIndex);
      for (int i = 0; i < word.length(); i++) {
        currentString.append(word.charAt(i));
        backtrack(stringList, resultList, wordIndex + 1, currentString);
        currentString.setLength(currentString.length() - 1);
      }
    }
  }

  private String[] getArrayFromList(List<String> list) {
    String[] strArray = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      strArray[i] = list.get(i);
    }
    return strArray;
  }

  private List<String> getListFromString(String S) {
    List<String> stringList = new LinkedList<>();
    int pointer = 0;
    StringBuilder currentStr = new StringBuilder();
    while (pointer < S.length()) {
      char currentChar = S.charAt(pointer);
      if (currentChar == '{') {
        pointer++;
        while (Character.isLetter(S.charAt(pointer)) || S.charAt(pointer) == ',') {
          if (S.charAt(pointer) != ',') currentStr.append(S.charAt(pointer));
          pointer++;
        }
      } else if (currentChar == '}') {
        stringList.add(currentStr.toString());
        currentStr = new StringBuilder();
        pointer++;
      } else if (Character.isLetter(currentChar)) {
        while (pointer < S.length() && Character.isLetter(S.charAt(pointer))) {
          currentStr.append(S.charAt(pointer));
          pointer++;
        }
        stringList.add(currentStr.toString());
        currentStr = new StringBuilder();
      }
    }
    return stringList;
  }

  public static void main(String[] args) {
      BraceExpansion b = new BraceExpansion();
    System.out.println(Arrays.toString(b.expand("{d,e}c{a,b}f")));
  }
}

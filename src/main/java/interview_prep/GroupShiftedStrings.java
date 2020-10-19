package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/group-shifted-strings/
 *
 * <p>Approach:
 *
 * <p>Runtime: O(N*Max(Len(N)))
 */
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    HashMap<List<Integer>, List<String>> diffMap = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      List<Integer> diffs = new ArrayList<>();
      char[] currentStr = strings[i].toCharArray();
      // diffs.add(currentStr.charAt(0) - 'a');
      for (int j = 1; j < currentStr.length; j++) {
        int diff = currentStr[j - 1] - currentStr[j];
        if (diff < 0) {
          diff += 26;
        }
        diffs.add(diff);
      }
      if (diffMap.containsKey(diffs)) {
        diffMap.get(diffs).add(strings[i]);
      } else {
        List<String> stringList = new ArrayList<>();
        stringList.add(strings[i]);
        diffMap.put(diffs, stringList);
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (List<Integer> key : diffMap.keySet()) {
      result.add(diffMap.get(key));
    }
    return result;
  }

  public static void main(String[] args) {
    String[] strings = new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    GroupShiftedStrings g = new GroupShiftedStrings();
    g.groupStrings(strings);
  }
}

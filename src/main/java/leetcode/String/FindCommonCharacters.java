package main.java.leetcode.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindCommonCharacters {
  public static List<String> commonChars(String[] A) {
    int numWords = A.length;
    HashMap<String, Integer> charMap = new HashMap<>();
    // starting with the first word
    for (int i = 0; i < A[0].length(); i++) {
      String currentChar = String.valueOf(A[0].charAt(i));
      charMap.put(currentChar, charMap.getOrDefault(currentChar, 0) + 1);
    }

    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[i].length(); j++) {
        String ch = String.valueOf(A[i].charAt(j));
        if (charMap.containsKey(ch)) {
          charMap.put(ch, charMap.get(ch) + 1);
        }
      }
    }
    LinkedList<String> output = new LinkedList<>();
    for (String key : charMap.keySet()) {
      int namOccurrence = charMap.get(key);
      namOccurrence -= numWords;
      while (namOccurrence >= 0) {
        output.add(key);
        namOccurrence -= numWords;
      }
    }
    return output;
  }

  public static void main(String[] args) {
    String[] input = {
      "acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"
    };
    System.out.println(commonChars(input));
  }
}

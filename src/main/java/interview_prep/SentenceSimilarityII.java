package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/expressive-words/
 *
 * <p>Example:
 *
 * <p><Example: Input: S = "heeellooo" words = ["hello", "hi", "helo"] Output: 1 Explanation: We can
 * extend "e" and "o" in the word "hello" to get "heeellooo". We can't extend "helo" to get
 * "heeellooo" because the group "ll" is not size 3 or more.
 *
 * <p>Approach:
 *
 * <p>Complexity - O(mn)
 */
public class SentenceSimilarityII {
  public boolean areSentencesSimilarTwo(
      String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) return false;
    HashMap<String, Set<String>> wordMap = generateBidirectionalGraph(pairs);
    for (int i = 0; i < words1.length; i++) {
      if (words1[i].equals(words2[i])) continue;
      String word1 = words1[i];
      String word2 = words2[i];
      Set<String> seen = new HashSet<>();
      if (!dfs(word1, word2, wordMap, seen)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(
      String word1, String word2, HashMap<String, Set<String>> wordMap, Set<String> seen) {
    if (wordMap.containsKey(word1) && wordMap.get(word1).contains(word2)) return true;
    if (!seen.contains(word1)) {
      seen.add(word1);
      if (wordMap.containsKey(word1)) {
        for (String neighbour : wordMap.get(word1)) {
          if (seen.contains(neighbour)) continue;
          return dfs(neighbour, word2, wordMap, seen);
        }
      }
    }
    return false;
  }

  private HashMap<String, Set<String>> generateBidirectionalGraph(List<List<String>> pairs) {
    HashMap<String, Set<String>> wordMap = new HashMap<>();
    for (int i = 0; i < pairs.size(); i++) {
      String firstWord = pairs.get(i).get(0);
      String secondWord = pairs.get(i).get(1);
      wordMap.putIfAbsent(firstWord, new HashSet<>());
      wordMap.get(firstWord).add(secondWord);
      wordMap.putIfAbsent(secondWord, new HashSet<>());
      wordMap.get(secondWord).add(firstWord);
    }
    return wordMap;
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/word-break/
 *
 * <p>Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation: Return true
 * because "leetcode" can be segmented as "leet code".
 *
 * <p>Approach: Recursive + Memoization
 */
public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    HashMap<String, Boolean> cache = new HashMap<>();
    for (String word : wordDict) set.add(word);
    return dfs(s, set, cache);
  }

  public boolean dfs(String s, Set<String> set, HashMap<String, Boolean> cache) {
    if (s.equals("")) return true;
    if (cache.containsKey(s)) return cache.get(s);
    for (int i = 1; i <= s.length(); i++) {
      if (set.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), set, cache)) {
        cache.put(s.substring(i, s.length()), true);
        return true;
      }
    }
    cache.put(s, false);
    return false;
  }
}

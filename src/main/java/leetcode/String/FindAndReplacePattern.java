package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    for (String word : words) {
      if (isMatch(word, pattern)) result.add(word);
    }
    return result;
  }

  public boolean isMatch(String word, String pattern) {
    HashMap<Character, Character> wordMap = new HashMap<>();
    HashMap<Character, Character> patternMap = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char w = word.charAt(i);
      char p = pattern.charAt(i);
      if (!wordMap.containsKey(w)) wordMap.put(w, p);
      if (!patternMap.containsKey(p)) patternMap.put(p, w);
      if (wordMap.get(w) != p || patternMap.get(p) != w) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    FindAndReplacePattern fp = new FindAndReplacePattern();
    String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
    String pattern = "abb";
    System.out.println(fp.findAndReplacePattern(words, pattern));
  }
}

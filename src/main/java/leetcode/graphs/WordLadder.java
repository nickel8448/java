package main.java.leetcode.graphs;

import java.util.*;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> seen = new HashSet<>();
    LinkedList<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int result = 0;
    while (!queue.isEmpty()) {
      ++result;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currentWord = queue.poll();
        if (currentWord.equals(endWord)) return result;
        List<String> children = getChildren(currentWord, wordList);
        for (String child : children) {
          if (!seen.contains(child)) {
            queue.offer(child);
            seen.add(child);
          }
        }
      }
    }
    return 0;
  }

  private List<String> getChildren(String word, List<String> wordList) {
    List<String> result = new ArrayList<>();
    for (String str : wordList) {
      int count = 0;
      for (int i = 0; i < word.length(); i++) {
        if (str.charAt(i) != word.charAt(i)) {
          count++;
        }
      }
      if (count == 1) {
        result.add(str);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    WordLadder wl = new WordLadder();
    String[] words = {
      "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
      "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
      "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as",
      "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
      "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st",
      "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr",
      "pa", "he", "lr", "sq", "ye"
    };
    ArrayList<String> a = new ArrayList<>(Arrays.asList(words));

    wl.ladderLength("qa", "sq", a);
  }
}

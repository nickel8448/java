package main.java.leetcode.Array;

import java.util.HashMap;
import java.util.LinkedList;

public class ShortestDistanceInStringArray {
  public static int shortestDistance(String[] words, String word1, String word2) {
    HashMap<String, LinkedList<Integer>> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      if (!map.containsKey(words[i])) {
        map.put(words[i], new LinkedList<>());
      }
      LinkedList<Integer> num = map.get(words[i]);
      num.add(i);
      map.put(words[i], num);
    }
    LinkedList<Integer> word1List = map.get(word1);
    LinkedList<Integer> word2List = map.get(word2);
    int word1ListLength = word1List.size();
    int word2ListLength = word2List.size();

    System.out.println(map);
    return 0;
  }

  public static void main(String[] args) {
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    shortestDistance(words, "1", "@");
  }
}

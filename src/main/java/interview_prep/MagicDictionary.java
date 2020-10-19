package main.java.interview_prep;

import java.util.*;

/** Problem: https://leetcode.com/problems/implement-magic-dictionary/ */
public class MagicDictionary {
  private class Trie {
    HashMap<Character, Trie> children;
    boolean isLeaf;

    Trie() {
      children = new HashMap<>();
      isLeaf = false;
    }
  }

  // Private variables for the class
  Trie root;

  public MagicDictionary() {
    root = new Trie();
  }

  public void buildDict(String[] dictionary) {
    for (String word : dictionary) {
      Trie head = root;
      for (char ch : word.toCharArray()) {
        if (!head.children.containsKey(ch)) {
          head.children.put(ch, new Trie());
        }
        head = head.children.get(ch);
      }
      head.isLeaf = true;
    }
  }

  public boolean search(String searchWord) {
    return searchInTrie(searchWord, 0, false, root);
  }

  private boolean searchInTrie(String word, int index, boolean hasChanged, Trie head) {
    if (index < word.length()) {
      if (head.children.containsKey(word.charAt(index))) {
        if (searchInTrie(word, index + 1, hasChanged, head.children.get(word.charAt(index))))
          return true;
      }
      if (!hasChanged) {
        for (char c : head.children.keySet()) {
          if (c != word.charAt(index)
              && searchInTrie(word, index + 1, true, head.children.get(c))) {
            return true;
          }
        }
      }
      return false; // The dictionary does not contain the character and one has already been
                    // flipped
    }
    return hasChanged && head.isLeaf;
  }
}

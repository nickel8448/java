package main.java.interview_prep;

import java.util.*;

public class WordDictionary {

  /** Trie class */
  private class Trie {
    HashMap<Character, Trie> children;
    boolean isLeaf;

    Trie() {
      children = new HashMap<>();
      isLeaf = false;
    }

    public Trie getChild(char ch) {
      return children.get(ch);
    }

    public void setChild(char ch) {
      children.put(ch, new Trie());
    }
  }

  /* Private variable */
  Trie root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new Trie();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    Trie head = root;
    for (char c : word.toCharArray()) {
      if (head.getChild(c) == null) {
        head.setChild(c);
      }
      head = head.getChild(c);
    }
    head.isLeaf = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return searchInNode(root, word);
  }

  private boolean searchInNode(Trie head, String word) {
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!head.children.containsKey(ch)) {
        if (ch == '.') {
          for (char x : head.children.keySet()) {
            Trie child = head.getChild(x);
            if (searchInNode(child, word.substring(i + 1))) {
              return true;
            }
          }
        }
        return false;
      } else {
        head = head.getChild(ch);
      }
    }
    return head.isLeaf;
  }

  public static void main(String[] args) {
    WordDictionary w = new WordDictionary();
    w.addWord("bod");
    w.addWord("bad");
    System.out.println(w.search(".ad"));
  }
}

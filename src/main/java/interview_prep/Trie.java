package main.java.interview_prep;

import java.util.*;

public class Trie {
  /** Private TrieNode class */
  private class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isLeaf;

    TrieNode() {
      children = new HashMap<>();
      isLeaf = false;
    }
  }

  /** Private variables for class Trie */
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode head = root;
    for (char ch : word.toCharArray()) {
      if (!head.children.containsKey(ch)) {
        head.children.put(ch, new TrieNode());
      }
      head = head.children.get(ch);
    }
    head.isLeaf = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode head = root;
    for (char ch : word.toCharArray()) {
      if (!head.children.containsKey(ch)) {
        return false;
      }
      head = head.children.get(ch);
    }
    return head.isLeaf;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode head = root;
    for (char ch : prefix.toCharArray()) {
      if (!head.children.containsKey(ch)) {
        return false;
      }
      head = head.children.get(ch);
    }
    return true;
  }
}

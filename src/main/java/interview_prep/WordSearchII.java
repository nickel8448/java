package main.java.interview_prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/word-search-ii/
 *
 * <p>Sample Input: board = [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
 * ['i','f','l','v'] ] words = ["oath","pea","eat","rain"] Output: ["eat","oath"]
 *
 * <p>Approach: 1) Backtrack
 * 
 * Runtime: O(N * (4 * 3^4))
 */
public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    // converting the words list to set to remove duplicates and remove
    // the words already found
    Set<String> wordSet = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      wordSet.add(words[i]);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        for (String word : wordSet) {
          backtrack(board, word, i, j, result, 0);
          if (result.contains(word)) {
            wordSet.remove(word);
          }
        }
        for (String word : result) wordSet.remove(word);
      }
    }
    return result;
  }

  public void backtrack(char[][] board, String word, int i, int j, List<String> result, int index) {
    if (index >= word.length()) {
      if (!result.contains(word)) result.add(word);
      return;
    }
    if (i < 0
        || j < 0
        || i >= board.length
        || j >= board[i].length
        || board[i][j] != word.charAt(index)) {
      return;
    }

    // movement {up, right, down, left}
    int[] rowMovement = {1, 0, -1, 0};
    int[] colMovement = {0, 1, 0, -1};
    board[i][j] = '#';
    for (int n = 0; n < 4; n++) {
      backtrack(board, word, i + rowMovement[n], j + colMovement[n], result, index + 1);
    }
    board[i][j] = word.charAt(index);
  }
}

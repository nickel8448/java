package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/sentence-screen-fitting/
 *
 * <p>Approach: 1) Loop through each row and check how many words can be fitted
 *
 * <p>Runtime: O(N*Max(Len(N)))
 */
public class SentenceScreenFitting {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    int wordIndex = 0;
    int sentenceLength = sentence.length;
    int numSentences = 0;
    for (int i = 0; i < rows; i++) {
      // try to add as many words in this row
      int colIndex = 0; // words cannot be broken so start at the top of the col
      while (colIndex < cols) {
        String currentWord = sentence[wordIndex % sentenceLength];
        if (currentWord.length() + colIndex <= cols) {
          wordIndex++;
          colIndex += currentWord.length() + 1;
          if ((wordIndex % sentenceLength) == 1) numSentences++;
        } else {
          break; // break and move to the next row
        }
      }
    }
    return numSentences;
  }

  public static void main(String[] args) {
    SentenceScreenFitting w = new SentenceScreenFitting();
    String[] s = new String[] {"a", "b", "e"};
    System.out.println(w.wordsTyping(s, 8, 7));
  }
}

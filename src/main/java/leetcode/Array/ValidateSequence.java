package main.java.leetcode.Array;

import java.util.List;

public class ValidateSequence {
  /**
   * Problem: https://www.algoexpert.io/questions/Validate%20Subsequence
   *
   * @param array
   * @param sequence
   * @return
   */
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    int sequenceIndex = 0;
    for (int value : array) {
      if (sequenceIndex == sequence.size()) break;
      if (sequence.get(sequenceIndex).equals(value)) sequenceIndex++;
    }
    return sequenceIndex == sequence.size();
  }
}

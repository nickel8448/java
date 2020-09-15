package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/merge-intervals/
 *
 * <p>Approach: Linear
 *
 * <p>Runtime: O(N)
 */
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(
        intervals,
        new Comparator<>() {
          @Override
          public int compare(int[] arrOne, int[] arrTwo) {
            return Integer.compare(arrOne[0], arrTwo[0]);
          }
        });
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        // There is no overlap. The previous end < current start
        merged.add(interval);
      } else {
        // There is an overlap from the previous end and the current end
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    int[][] result = new int[merged.size()][2];
    for (int i = 0; i < merged.size(); i++) {
      result[i] = merged.get(i);
    }
    return result;
  }
}

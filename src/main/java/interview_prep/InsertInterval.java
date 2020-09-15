package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/insert-interval/
 *
 * <p>Input: [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed and the rest of
 * intervals are non-overlapping.
 *
 * <p>Runtime: O(nlogn) Status: Time limit exceeded
 */
public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) return new int[][] {newInterval};
    // Adding the new interval to the current set of intervals
    int[][] placeholderIntervals = new int[intervals.length + 1][2];
    for (int i = 0; i < intervals.length; i++) {
      placeholderIntervals[i] = intervals[i];
    }
    placeholderIntervals[placeholderIntervals.length - 1] = newInterval;
    intervals = placeholderIntervals.clone();
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
          }
        });

    // Checking if overlap is required
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
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

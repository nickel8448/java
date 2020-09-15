package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/non-overlapping-intervals/
 *
 * <p>Input: [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed and the rest of
 * intervals are non-overlapping.
 *
 * <p>Runtime: O(nlogn) Status: Time limit exceeded
 */
public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
    // 1. Sorting the interval based on start time
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
          }
        });
    int numRemoved = 0;
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (i == 0) {
      } else {
        // There are three scenarios
        // 1. There is no overlap, in this case we update the previous to current
        // 2. The current interval is overlapping with previous in a way that
        //    previous is a bigger interval than the current one and since this
        //    is a greedy approach, we choose the smaller one to accomodate more
        //    intervals
        // 3. Partial overlap
        if (prev[0] <= intervals[i][0] && prev[1] > intervals[i][1]) {
          prev = intervals[i];
          numRemoved++;
        } else if (prev[1] > intervals[i][0]) {
          numRemoved++;
        } else {
          prev = intervals[i];
        }
      }
    }
    return numRemoved;
  }
}

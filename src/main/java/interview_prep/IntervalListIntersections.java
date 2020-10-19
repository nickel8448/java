package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/interval-list-intersections/
 *
 * <p><pInput: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3] has the minimal
 * length under the problem constraint.
 *
 * Approach:
 * 1) Add both the arrays to one list and sort it
 * 2) Create a new list to store intersections
 * 3)
 * <p>Runtime: O(S + T)
 */

public class IntervalListIntersections {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> ans = new ArrayList<>();
    int i = 0, j = 0;
    while (i < A.length && j < B.length) {
      int low = Math.max(A[i][0], B[j][0]);
      int high = Math.min(A[i][1], B[j][1]);
      if (low <= high) {
        ans.add(new int[]{low, high});
      }
      if (A[i][1] < B[j][1])
        i++;
      else
        j++;
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
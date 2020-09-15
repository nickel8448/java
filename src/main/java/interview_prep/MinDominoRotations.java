package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * <p>Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2] Output: 2
 *
 * <p>Runtime: O(2 * M * N)
 *
 * <p>Status: 112/113 tests passed. One is time limit exceeded
 */
public class MinDominoRotations {
  public int minDominoRotations(int[] A, int[] B) {
    int n = A.length;
    int rotations = check(A[0], B, A, n);
    if (rotations != -1 || A[0] == B[0]) return rotations;
    else return check(B[0], B, A, n);
  }

  public int check(int x, int[] A, int[] B, int n) {
    int rotationsA = 0;
    int rotationsB = 0;
    for (int i = 0; i < n; i++) {
      if (A[i] != x && B[i] != x) return -1;
      else if (A[i] != x) rotationsA++;
      else if (B[i] != x) rotationsB++;
    }
    return Math.min(rotationsA, rotationsB);
  }
}

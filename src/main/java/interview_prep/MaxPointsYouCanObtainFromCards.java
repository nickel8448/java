package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * <p>Input: cardPoints = [1,2,3,4,5,6,1], k = 3 Output: 12 Explanation: After the first step, your
 * score will always be 1. However, choosing the rightmost card first will maximize your total
 * score. The optimal strategy is to take the three cards on the right, giving a final score of 1 +
 * 6 + 5 = 12.
 *
 * <p>[100, 40, 17, 9, 73, 75] k = 3
 *
 * <p>Approach: Sliding window
 *
 * <p>Complexity - O(n)
 */
public class MaxPointsYouCanObtainFromCards {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int leftSum = 0;
    for (int i = 0; i < k; i++) {
      leftSum += cardPoints[i]; // 157
    }
    int result = leftSum;
    int rightSum = 0;
    for (int i = 0; i < k; i++) {
      leftSum -= cardPoints[k - 1 - i]; // 140
      rightSum += cardPoints[n - 1 - i]; // 75
      result = Math.max(result, rightSum + leftSum);
    }
    return result;
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/daily-temperatures/
 *
 * <p>For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * <p>Approach:
 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] T) {
    // min monotonic queue - the next greater or the smallest number stays on top
    Stack<Integer> minQueue = new Stack<>();
    int[] result = new int[T.length];
    for (int i = T.length - 1; i >= 0; i--) {
      while (!minQueue.isEmpty() && T[i] >= T[minQueue.peek()]) {
        minQueue.pop();
      }
      result[i] = minQueue.isEmpty() ? 0 : minQueue.peek() - i;
      minQueue.push(i);
    }
    return result;
  }
}

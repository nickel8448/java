package main.java.interview_prep;

import java.util.*;

/**
 * Problem:
 *
 * <p>Approach: 1) Find perfect squares until <= n 2) Sort the list in decreasing order 3) Backtrack
 * on it to find the least numbers? (find out how to memoize)
 *
 * <p>Runtime:
 */
public class NumSquares {
  public int numSquares(int n) {
    HashMap<Integer, Integer> cache = new HashMap<>();
    return backtrack(n, cache);
  }

  private int backtrack(int n, HashMap<Integer, Integer> cache) {
    if (n <= 3) return n;
    if (cache.containsKey(n)) {
      return cache.get(n);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      min = Math.min(min, backtrack(n - (i * i), cache) + 1);
    }
    cache.put(n, min);
    return min;
  }
}

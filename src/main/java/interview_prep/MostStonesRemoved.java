package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/is-subsequence/
 *
 * <p>Approach: DFS
 *
 * <p>Runtime: O(N ^ 2)
 */
public class MostStonesRemoved {
  public int removeStones(int[][] stones) {
    Set<int[]> visitedNodes = new HashSet<>();
    int numberConnectedComponent = 0;
    for (int[] stone : stones) {
      if (!visitedNodes.contains(stone)) {
        dfs(stone, stones, visitedNodes);
        numberConnectedComponent += 1;
      }
    }
    // From all the connected components I can only keep one stone
    // From all the stones, I only keep one from each connected component
    return stones.length - numberConnectedComponent;
  }

  private void dfs(int[] stone, int[][] stones, Set<int[]> visitedNodes) {
    visitedNodes.add(stone);
    for (int[] s2 : stones) {
      if (!visitedNodes.contains(s2)) {
        if (stone[0] == s2[0] || stone[1] == s2[1]) {
          dfs(s2, stones, visitedNodes);
        }
      }
    }
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/as-far-from-land-as-possible/
 *
 * <p>Input: [[1,0,1],[0,0,0],[1,0,1]] Output: 2 Explanation: The cell (1, 1) is as far as possible
 * from all the land with distance 2.
 *
 * <p>Runtime:
 */
public class AsFarFromLandAsPossible {
  public int maxDistance(int[][] grid) {
    LinkedList<int[]> queue = new LinkedList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          queue.add(new int[] {i, j});
        }
      }
    }
    int distance = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int[] row = {1, 0, -1, 0};
      int[] col = {0, 1, 0, -1};
      while (size != 0) {
        int[] current = queue.poll();
        for (int i = 0; i < 4; i++) {
          int newRow = current[0] + row[i];
          int newCol = current[1] + col[i];
          if (newRow >= 0
              && newCol >= 0
              && newRow < grid.length
              && newCol < grid[0].length
              && grid[newRow][newCol] == 0) {
            queue.add(new int[] {newRow, newCol});
            grid[newRow][newCol] = 1;
          }
        }
        size--;
      }
      distance++;
    }
    return distance == 1 ? -1 : distance - 1;
  }

  private void DFS(int[][] grid, int i, int j, int[][] distance, int len, boolean[][] visited) {
    if (i < 0
        || j < 0
        || i >= grid.length
        || j >= grid[0].length
        || visited[i][j] == true
        || grid[i][j] == -1) return;
    visited[i][j] = true;
    distance[i][j] = Math.min(distance[i][j], len);
    max = Math.max(distance[i][j], max);
    int[] row = {1, 0, -1, 0};
    int[] col = {0, 1, 0, -1};
    for (int k = 0; k < 4; k++) {
      int newRow = row[k] + i;
      int newCol = col[k] + j;
      DFS(grid, newRow, newCol, distance, len + 1, visited);
    }
  }
}

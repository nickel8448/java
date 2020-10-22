package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * <p><Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * <p>Output: 7
 *
 * <p>Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2), the point
 * (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is
 * minimal. So return 7.
 *
 * <p>Approach: BFS
 *
 * <p>Complexity - (B*M*N) (B: # of buildings) and starting from empty places O(E*M*N) (E: # of
 * empty places)
 */
public class ShortestDistanceFromAllBuildings {
  public int shortestDistance(int[][] grid) {
    int numRow = grid.length;
    int numCol = grid[0].length;
    int[] rowMovement = {1, 0, -1, 0};
    int[] colMovement = {0, 1, 0, -1};
    int[][] distance = new int[grid.length][grid[0].length]; // distance for each building
    int[][] reach = new int[grid.length][grid[0].length]; // number of buildings reached
    int numBuildings = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          numBuildings++;
          LinkedList<int[]> queue = new LinkedList<>();
          queue.add(new int[] {i, j});
          boolean[][] visited = new boolean[grid.length][grid[0].length];
          int level = 1;
          while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
              int[] current = queue.poll();
              for (int k = 0; k < 4; k++) {
                int newRow = current[0] + rowMovement[k];
                int newCol = current[1] + colMovement[k];
                if (newRow >= 0 && newCol >= 0 && newRow < numRow && newCol < numCol) {
                  if (!visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    reach[newRow][newCol]++;
                    distance[newRow][newCol] += level;
                    queue.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                  }
                }
              }
            }
            level++;
          }
        }
      }
    }
    int shortest = Integer.MAX_VALUE;
    for (int i = 0; i < numRow; i++) {
      for (int j = 0; j < numCol; j++) {
        if (grid[i][j] == 0 && reach[i][j] == numBuildings) {
          shortest = Math.min(distance[i][j], shortest);
        }
      }
    }
    return shortest;
  }
}

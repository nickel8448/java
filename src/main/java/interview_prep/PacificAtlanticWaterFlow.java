package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/
 *
 * <p>Runtime: O(2 * M * N)
 *
 * <p>Status: 112/113 tests passed. One is time limit exceeded
 */
public class PacificAtlanticWaterFlow {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> result = new LinkedList<>();
    boolean[][] visited;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, i, j, false, false, result, visited);
      }
    }
    return result;
  }

  private void dfs(
      int[][] matrix,
      int i,
      int j,
      boolean touchesAtlantic,
      boolean touchesPacific,
      List<List<Integer>> result,
      boolean[][] visited) {
    visited[i][j] = true;
    if (i == 0 || j == 0) {
      touchesPacific = true;
    }
    if (i == matrix.length - 1 || j == matrix[0].length - 1) {
      touchesAtlantic = true;
    }
    if (touchesAtlantic && touchesPacific) {
      LinkedList<Integer> coordinates = new LinkedList<>();
      coordinates.add(i);
      coordinates.add(j);
      if (!result.contains(coordinates)) {
        result.add(coordinates);
      }
      return;
    }
    int[] rowMovement = {1, 0, -1, 0};
    int[] colMovement = {0, 1, 0, -1};
    for (int k = 0; k < 4; k++) {
      int rowMove = i + rowMovement[k];
      int colMove = j + colMovement[k];
      if (rowMove >= 0
          && colMove >= 0
          && rowMove < matrix.length
          && colMove < matrix[0].length
          && !visited[rowMove][colMove]) {
        int nextWaterLevel = matrix[rowMove][colMove];
        if (nextWaterLevel <= matrix[i][j]) {
          dfs(
              matrix,
              i + rowMovement[k],
              j + colMovement[k],
              touchesAtlantic,
              touchesPacific,
              result,
              visited);
        }
      }
    }
  }
}

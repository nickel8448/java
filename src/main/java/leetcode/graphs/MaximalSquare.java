package main.java.leetcode.graphs;

/** https://leetcode.com/problems/maximal-square/ Status: Pending */
public class MaximalSquare {

  private int max = 0;

  public int maximalSquare(char[][] matrix) {
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        boolean[][] stackVisited = visited;
        bfs(matrix, i, j, stackVisited, 0);
      }
    }
    return max * max;
  }

  private void bfs(char[][] matrix, int i, int j, boolean[][] stackVisited, int current) {
    if (current > max) {
      max = current;
    }
    if (j + 1 < matrix[i].length && i + 1 < matrix.length) {
      char right = matrix[i][j + 1];
      char corner = matrix[i + 1][j + 1];
      char bottom = matrix[i + 1][j];
      if (right == '1' && corner == '1' && bottom == '1') {}
    }
  }
}

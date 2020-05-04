package main.java.leetcode.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    for (int i = 0; i < k; i++) {
      for (int row = 0; row < grid.length; row++) {
        // grid[i][j] to grid[i][j+1]
        Integer prev = null;
        for (int col = 1; col < grid[i].length; col++) {}
      }
      // grid[m-1][n-1] moves to grid[0][0]
    }
    List<List<Integer>> ret = new ArrayList<>();
    return ret;
  }
}

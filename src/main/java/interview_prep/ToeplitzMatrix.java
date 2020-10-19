package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/toeplitz-matrix/
 *
 * <p>Approach: Check with its top left neighbour
 */
public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int numRow = matrix.length;
    int numCol = matrix[0].length;
    for (int i = 0; i < numRow; i++) {
      for (int j = 0; j < numCol; j++) {
        if (i - 1 >= 0 && j - 1 >= 0) {
          int topLeft = matrix[i - 1][j - 1];
          if (matrix[i - 1][j - 1] != matrix[i][j]) return false;
        }
      }
    }
    return true;
  }
}

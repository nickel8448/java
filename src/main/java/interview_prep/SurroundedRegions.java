package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/jump-game-ii/
 *
 * <p>Example:
 *
 * <p>X X X X X O O X X X O X X O X X After running your function, the board should be:
 *
 * <p>X X X X X X X X X X X X X O X X Explanation:
 *
 * <p>Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O'
 * on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 *
 * <p>Approach: 1) Run DFS on 'O' in the first column and the last column 2) Run DFS on 'O' in the
 * first row and the last row 3) Mark all the 'O' from DFS as '*' 4) Loop through the entire matrix
 * and if 'O' is encountered, convert it to 'X' 5) If '*' is encountered in matrix convert it to 'O'
 *
 * <p>Complexity - O(3MN) -> O(MN) Explanation - Going through the matrix twice with DFS and the
 * last time to change the matrix
 */
public class SurroundedRegions {
  public void solve(char[][] board) {
    int numRows = board.length;
    int numCols = board[0].length;
    // Traversing through the rows and running DFS on first column and last column
    for (int i = 0; i < numRows; i++) {
      if (board[i][0] == 'O') dfs(board, i, 0);
      if (board[i][numCols - 1] == 'O') dfs(board, i, numCols - 1);
    }

    // Traversing through the cols and running DFS on first row and last row
    for (int i = 0; i < numCols; i++) {
      if (board[0][i] == 'O') dfs(board, 0, i);
      if (board[numRows - 1][i] == 'O') dfs(board, numRows - 1, i);
    }

    // At this stage, the board has all 'O' which are not surrounded completely
    // marked as '*'
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == '*') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void dfs(char[][] board, int row, int col) {
    if (row < 0
        || col < 0
        || row >= board.length
        || col >= board[0].length
        || board[row][col] == '*'
        || board[row][col] == 'X') return;
    board[row][col] = '*';
    int[] rowTraversal = {1, 0, -1, 0};
    int[] colTraversal = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) {
      int nextRow = rowTraversal[i] + row;
      int nextCol = colTraversal[i] + col;
      dfs(board, nextRow, nextCol);
    }
  }
}

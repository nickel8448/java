package main.java.leetcode.Backtracking;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    // HashMap<Character, LinkedList<int[][]>> wordMap = new HashMap<>();
    // for(int i = 0; i < board.length; i++) {
    //   for(int j = 0; j < board[i].length; j++) {
    //     wordMap.putIfAbsent()
    //   }
    // }
    boolean found = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        found = backtrack(i, j, word, 1, board);
        if (found == true) return true;
      }
    }
    return found;
  }

  private boolean backtrack(int i, int j, String word, int n, char[][] board) {
    if (n == word.length()) {
      return true;
    }
    if (i < 0 || j < 0 || i > word.length() || j > word.length() || board[i][j] != word.charAt(n)) {
      return false;
    }
    board[i][j] = '#';
    int[] rowAdjacement = {1, 0, -1, 0};
    int[] columnAdjacement = {0, 1, 0, -1};
    for (int num = 0; num < rowAdjacement.length; num++) {
      if (backtrack(i + rowAdjacement[num], j + columnAdjacement[num], word, n + 1, board)) {
        return true;
      }
    }
    board[i][j] = word.charAt(n);
    return false;
  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
    char[][] board2 = {{'a', 'b'}};
    WordSearch w = new WordSearch();
    System.out.println(w.exist(board3, "ABCESEEEFS"));
  }

  // "ABCESEEEFS"
  // [["A","B","C","E"]
  // ["S","F","E","S"]
  // ["A","D","E","E"]]
}

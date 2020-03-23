package main.java.LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem link: https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/
 * Status: Solved
 */

public class ValidSudoku {

   public static boolean isValidSudoku(char[][] board) {
       Set<String> seen = new HashSet<>();
       for(int i = 0; i < board.length; ++i) {
           for(int j = 0; j < board[i].length; ++j) {
               if(board[i][j] != '.') {
                   String rowText = new String("Row: " + i + ": " + board[i][j]);
                   String colText = new String("Col: " + j + ": " + board[i][j]);
                   String boxText = new String("Box: " + i / 3 + "-" + j / 3 + ": " + board[i][j]);
                   if(!seen.add(rowText) || !seen.add(colText) || !seen.add(boxText)) {
                       return false;
                   }
               }
           }
       }
       return true;
   }

    public static void main(String[] args) {
        char[][] arr = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(arr));
    }
}

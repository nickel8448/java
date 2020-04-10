package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        initializeBoard(board, n);
        solveNQueensUtil(board, 0, n);
        return board;
    }


    public static boolean solveNQueensUtil(List<List<String>> board, int row, int n) {
        if(row >= n) return true;
        // Chose n because those are the number of columns
        for(int i = 0; i < n; i++) {
            if(isValidMove(board, row, i)) {
                StringBuilder newLine = new StringBuilder(board.get(row).get(0));
                newLine.setCharAt(i, 'Q');
                board.get(row).set(0, newLine.toString());
                if(solveNQueensUtil(board, row + 1, n)) {
                    return true;
                }
                newLine.setCharAt(i, '.');
                board.get(row).set(0, newLine.toString());
            }
        }
        return false;
    }


    public static boolean isValidMove(List<List<String>> board, int row, int col) {
        // Check row
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(0).charAt(col) == 'Q' && i != row) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.get(0).get(0).length(); i++) {
            if (board.get(row).get(0).charAt(i) == 'Q' && i != col) {
                return false;
            }
        }

        // Check diagonal
        int diff = row - col;
        int sum = row + col;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).get(0).length(); j++) {
                if(i != row || j != col) {
                    if (i + j == sum || i - j == diff) {
                        if (board.get(i).get(0).charAt(j) == 'Q') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public static void initializeBoard(List<List<String>> board, int n) {
        for(int j = 0; j < n; j++) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < n; i++) {
                temp.append(".");
            }
            ArrayList<String> toAdd = new ArrayList<>();
            toAdd.add(temp.toString());
            board.add(toAdd);
        }
    }

    
    public static void printBoard(List<List<String>> board) {
        for(int i = 0; i < board.size(); i++) {
            System.out.println(board.get(i));
        }
    }

    public static void main(String[] args) {
        List<List<String>> board = solveNQueens(4);
        printBoard(board);
    }
}

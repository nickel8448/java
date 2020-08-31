package main.java.interview_prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/word-search/
 *
 * Sample:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * Approach:
 * 1) BFS - Got it to work to some extent. Passed 81/89 test cases
 * 2) Backtrack
 *
 * Runtime:
 */
public class WordSearch {

    private class Position {
        int x;
        int y;
        char c;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Position(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(breadthFirstSearch(board, i, j, word))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean breadthFirstSearch(char[][] board, int x, int y, String word) {
        // Declaring row and column movements
        // {right, down, left, up}
        List<Position> marked = new ArrayList<>();
        marked.add(new Position(x, y, word.charAt(0)));
        char[][] traversalBoard = board.clone();
        int[] rowMovements = {0, 1, 0, -1};
        int[] columnMovements = {1, 0, -1, 0};
        int charPosition = 1;  // starting char position
        LinkedList<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        while(!queue.isEmpty()) {
            Position currentPos = queue.pollFirst();
            boolean foundNextChar = false;
            traversalBoard[currentPos.x][currentPos.y] = 'x';
            for (int i = 0; i < 4; i++) {
                int row = currentPos.x + rowMovements[i];
                int col = currentPos.y + columnMovements[i];
                if (charPosition == word.length())
                    return true;
                if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || traversalBoard[row][col] == 'x')
                    continue;
                if (traversalBoard[row][col] == word.charAt(charPosition)) {
                    foundNextChar = true;
                    queue.add(new Position(row, col));
                    marked.add(new Position(row, col, word.charAt(charPosition)));
                }
            }
            if (foundNextChar)
                charPosition++;
        }
        for (Position pos : marked) {
            board[pos.x][pos.y] = pos.c;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "SEE"));
    }
}

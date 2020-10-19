package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/walls-and-gates/
 *
 * <p>Example:
 *
 * <p><INF -1 0 INF INF INF INF -1 INF -1 INF -1 0 -1 INF INF
 *
 * <p>Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O'
 * on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 *
 * <p>Approach: Start by looping through the Matrix and getting all the nodes with 0 1) Start BFS if
 * a 0 is found Adding a sentinel node so that I know that one part of BFS has finished 2) Each
 * level of BFS will be a plus one 3) The new value will be added and if the value is not inifite,
 * take the lesser of the current and the new value
 *
 * <p>Complexity - O(mn)
 */
public class WallsAndGates {
  private class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void wallsAndGates(int[][] rooms) {
    LinkedList<Node> queue = new LinkedList<>();
    int n = rooms.length;
    int m = rooms[0].length;

    // Adding all nodes with 0 to the queue
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new Node(i, j));
        }
      }
    }

    // Starting BFS
    while (!queue.isEmpty()) {
      Node currentNode = queue.pollFirst();
      int[] rowDir = {1, 0, -1, 0};
      int[] colDir = {0, 1, 0, -1};
      for (int i = 0; i < 4; i++) {
        int rowMove = currentNode.x + rowDir[i];
        int colMove = currentNode.y + colDir[i];
        if (rowMove < 0
            || colMove < 0
            || rowMove >= n
            || colMove >= m
            || rooms[rowMove][colMove] != Integer.MAX_VALUE) {
          continue;
        }
        rooms[rowMove][colMove] =
            Math.min(rooms[rowMove][colMove], rooms[currentNode.x][currentNode.y] + 1);
        queue.add(new Node(rowMove, colMove));
      }
    }
  }
}

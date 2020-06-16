package main.java.leetcode.graphs;

import java.util.LinkedList;

public class MaximalSquare {

  private class node {
    int x;
    int y;

    node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private int max = 0;

  public int maximalSquare(char[][] matrix) {
    LinkedList<node> queue = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '1') {
          int currentSize = 0;
          boolean[][] visited = new boolean[matrix.length][matrix[i].length];
          queue.add(new node(i, j));
          while (queue.size() != 0) {
            node currentNode = queue.poll();
            visited[currentNode.x][currentNode.y] = true;
            if (currentNode.x + 1 < matrix.length && currentNode.y + 1 < matrix[i].length) {
              char rightChar = matrix[currentNode.x][currentNode.y + 1];
              char cornerChar = matrix[currentNode.x + 1][currentNode.y + 1];
              char bottomChar = matrix[currentNode.x + 1][currentNode.y];
              if (rightChar == '1' && cornerChar == '1' && bottomChar == '1') {
                if (visited[currentNode.x][currentNode.y + 1] == false)
                  queue.add(new node(currentNode.x, currentNode.y + 1));
                if (visited[currentNode.x + 1][currentNode.y + 1] == false)
                  queue.add(new node(currentNode.x + 1, currentNode.y + 1));
                if (visited[currentNode.x + 1][currentNode.y] == false)
                  queue.add(new node(currentNode.x + 1, currentNode.y));
                currentSize++;
              }
            }
          }
        }
      }
    }
    return max * max;
  }
}

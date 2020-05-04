package main.java.leetcode.Array;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrangesRotting {

  private static final int[][] nearbyOrange = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public static class Orange {
    int x;
    int y;
    int minute;

    Orange(int x, int y, int minute) {
      this.x = x;
      this.y = y;
      this.minute = minute;
    }
  }

  public static boolean isInsideGrid(int[][] grid, int[] coordinate) {
    int x = coordinate[0];
    int y = coordinate[1];
    if (x >= grid.length || x < 0) {
      return false;
    }
    if (y >= grid[x].length || y < 0) {
      return false;
    }
    return true;
  }

  public static int[] nearbyCoordinate(Orange currentOrange, int counter) {
    int xCoordinate = nearbyOrange[counter][0] + currentOrange.x;
    int yCoordinate = nearbyOrange[counter][1] + currentOrange.y;
    return new int[] {xCoordinate, yCoordinate};
  }

  public static int orangesRotting(int[][] grid) {
    // Queueing up all the rotten oranges
    int freshCount = 0;
    Queue<Orange> orangeQueue = new ArrayDeque<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          orangeQueue.add(new Orange(i, j, 0));
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }
    int max = 0;
    while (!orangeQueue.isEmpty()) {
      Orange currentOrange = orangeQueue.poll();
      max = currentOrange.minute;
      // Contaminate the oranges near by
      for (int i = 0; i < 4; i++) {
        int[] currentCoordinate = nearbyCoordinate(currentOrange, i);
        if (isInsideGrid(grid, currentCoordinate)) {
          if (grid[currentCoordinate[0]][currentCoordinate[1]] == 1) {
            grid[currentCoordinate[0]][currentCoordinate[1]] = 2;
            orangeQueue.add(new Orange(currentCoordinate[0], currentCoordinate[1], max + 1));
            freshCount--;
          }
        }
      }
    }
    return freshCount == 0 ? max : -1;
  }

  public static void main(String[] args) {
    int[][] oranges = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(orangesRotting(oranges));
  }
}

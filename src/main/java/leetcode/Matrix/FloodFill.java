package main.java.leetcode.Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FloodFill {
  /**
   * Problem: https://leetcode.com/problems/flood-fill/
   *
   * @param image
   * @param sr
   * @param sc
   * @param newColor
   * @return
   */
  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int startColour = image[sr][sc];
    int[][] visited = new int[image.length][image[0].length];
    image[sr][sc] = newColor; // setting the new colour to the source
    Queue<int[]> points = new ArrayDeque<>();
    points.add(new int[] {sr, sc});
    while (!points.isEmpty()) {
      int[] currentPoint = points.poll();
      // top point
      int top = currentPoint[0] - 1;
      if (top >= 0 && image[top][currentPoint[1]] == startColour) {
        if (visited[top][currentPoint[1]] == 0) {
          image[top][currentPoint[1]] = newColor;
          points.add(new int[] {top, currentPoint[1]});
          visited[top][currentPoint[1]] = 1;
        }
      }
      // bottom point
      int bottom = currentPoint[0] + 1;
      if (bottom < image.length && image[bottom][currentPoint[1]] == startColour) {
        if (visited[bottom][currentPoint[1]] == 0) {
          image[bottom][currentPoint[1]] = newColor;
          points.add(new int[] {bottom, currentPoint[1]});
          visited[bottom][currentPoint[1]] = 1;
        }
      }
      // left
      int left = currentPoint[1] - 1;
      if (left >= 0 && image[currentPoint[0]][left] == startColour) {
        if (visited[currentPoint[0]][left] == 0) {
          image[currentPoint[0]][left] = newColor;
          points.add(new int[] {currentPoint[0], left});
          visited[currentPoint[0]][left] = 1;
        }
      }
      // right
      int right = currentPoint[1] + 1;
      if (right < image[0].length && image[currentPoint[0]][right] == startColour) {
        if (visited[currentPoint[0]][right] == 0) {
          image[currentPoint[0]][right] = newColor;
          points.add(new int[] {currentPoint[0], right});
          visited[currentPoint[0]][right] = 1;
        }
      }
    }
    return image;
  }

  public static int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
    int startColour = image[sr][sc];
    if (startColour != newColor) dfs(image, sr, sc, startColour, newColor);
    return image;
  }

  public static void dfs(int[][] image, int r, int c, int startColour, int newColor) {
    if (image[r][c] == startColour) {
      image[r][c] = newColor;
      if (r >= 1) dfs(image, r - 1, c, startColour, newColor);
      if (c >= 1) dfs(image, r, c - 1, startColour, newColor);
      if (r + 1 < image.length) dfs(image, r + 1, c, startColour, newColor);
      if (c + 1 < image[0].length) dfs(image, r, c + 1, startColour, newColor);
    }
  }

  public static void main(String[] args) {
    int[][] image = {
      {1, 1, 1},
      {1, 1, 0},
      {1, 0, 1}
    };
    floodFillDFS(image, 1, 1, 2);
    System.out.println(Arrays.deepToString(image));
  }
}

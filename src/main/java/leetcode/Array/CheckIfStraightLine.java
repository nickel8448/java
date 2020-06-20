package main.java.leetcode.Array;

public class CheckIfStraightLine {
  public boolean checkStraightLine(int[][] coordinates) {
    double diff = 0;
    for (int i = 1; i < coordinates.length; i++) {
      double x1 = coordinates[i - 1][0];
      double y1 = coordinates[i - 1][1];
      double x2 = coordinates[i][0];
      double y2 = coordinates[i][1];
      double currentDiff = (y2 - y1) / (x2 - x1);
      if (i == 1) {
        diff = currentDiff;
      } else {
        if (currentDiff != diff) return false;
      }
    }
    return true;
  }
}

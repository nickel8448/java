package main.java.interview_prep;

/**
 * Problem:
 *
 * <p>Approach: 1) Find perfect squares until <= n 2) Sort the list in decreasing order 3) Backtrack
 * on it to find the least numbers? (find out how to memoize)
 *
 * <p>Runtime:
 */
public class AlphabetBoardPath {
  public String alphabetBoardPath(String target) {
    if (target == null) return "";
    char[] chars = target.toCharArray();
    StringBuilder sb = new StringBuilder();
    int prevRow = 0, prevCol = 0;
    for (int i = 0; i < chars.length; i++) {
      int requiredRow = (chars[i] - 'a') / 5;
      int requiredCol = (chars[i] - 'a') % 5;
      if (requiredRow == prevRow && requiredCol == prevCol) {
        sb.append("!");
      } else {
        sb.append(getMovement(prevRow, prevCol, requiredRow, requiredCol));
        sb.append("!");
        prevRow = requiredRow;
        prevCol = requiredCol;
      }
    }
    return sb.toString();
  }

  private String getMovement(int prevRow, int prevCol, int requiredRow, int requiredCol) {
    StringBuilder movement = new StringBuilder();
    while (prevRow > requiredRow) {
      prevRow--;
      movement.append("U");
    }
    while (prevCol < requiredCol) {
      movement.append("R");
      prevCol++;
    }
    while (prevCol > requiredCol) {
      prevCol--;
      movement.append("L");
    }
    while (prevRow < requiredRow) {
      movement.append("D");
      prevRow++;
    }
    return movement.toString();
  }
}

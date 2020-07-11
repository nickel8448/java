package main.java.leetcode.DynamicProgramming;

public class ScoreCombinations {
  int totalNumber = 0;

  public int totalWaysToReachScore(int finalScore, int[] pointEvents) {
    backtrack(finalScore, pointEvents, 0);
    return totalNumber;
  }

  private void backtrack(int finalScore, int[] pointEvents, int currentSum) {
    if (currentSum == finalScore) {
      totalNumber++;
    } else {
      for (int i = 0; i < pointEvents.length; i++) {
        if (currentSum + pointEvents[i] <= finalScore) {
          backtrack(finalScore, pointEvents, currentSum + pointEvents[i]);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] pointEvents = {2, 3, 7};
    ScoreCombinations s = new ScoreCombinations();
    System.out.println(s.totalWaysToReachScore(12, pointEvents));
  }
}

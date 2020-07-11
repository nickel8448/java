package main.java.leetcode.DynamicProgramming;

import java.util.List;

/** Problem: https://leetcode.com/problems/triangle/ */
public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size()];
    fillDpLastLayer(dp, triangle.get(triangle.size() - 1));
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> currentLayer = triangle.get(i);
      for (int j = 0; j < currentLayer.size(); j++) {
        int left = dp[j];
        int right = dp[j + 1];
        int minSumDirection = Math.min(left, right);
        dp[j] = currentLayer.get(j) + minSumDirection;
      }
    }
    return dp[0];
  }

  private void fillDpLastLayer(int[] dp, List<Integer> layer) {
    for (int i = 0; i < layer.size(); i++) {
      dp[i] = layer.get(i);
    }
  }
}

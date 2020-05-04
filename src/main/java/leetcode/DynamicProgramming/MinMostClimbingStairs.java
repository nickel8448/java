package main.java.leetcode.DynamicProgramming;

public class MinMostClimbingStairs {
  public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length];
    dp[0] = Math.min(cost[0], cost[1]);
    dp[1] = Math.min(cost[1] + dp[0], dp[0]);
    for (int i = 2; i < cost.length; i++) {
      dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    }
    return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
  }

  public static void main(String[] args) {
    int[] cost = {10, 15, 20};
    int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int[] cost3 = {1, 2, 1, 3, 7, 10, 15};
    cost.clone();
    System.out.println(minCostClimbingStairs(cost));
    System.out.println(minCostClimbingStairs(cost2));
    System.out.println(minCostClimbingStairs(cost3));
  }
}

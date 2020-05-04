package main.java.leetcode.DynamicProgramming;

public class ClimbingStairs {
  int numWays = 0;
  /**
   * Problem: https://leetcode.com/problems/climbing-stairs/
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    if (n == 1) return 1;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    ClimbingStairs cs = new ClimbingStairs();
    System.out.println(cs.climbStairs(44));
  }
}

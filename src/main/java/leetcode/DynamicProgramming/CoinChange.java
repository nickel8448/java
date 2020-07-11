package main.java.leetcode.DynamicProgramming;

import java.util.Arrays;

// Input: coins = [1, 2, 5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

public class CoinChange {
  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
        for (int coin : coins) {
            if (i - coin >= 0) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    System.out.println(coinChange(coins, 11));
  }
}

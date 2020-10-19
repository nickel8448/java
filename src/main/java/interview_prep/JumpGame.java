package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/jump-game/
 *
 * <p>Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3
 * steps to the last index.
 *
 * <p>Approach: 1) Backtracking - Complexity O(2^N) 2) Memoization with Backtracking top-down -
 * O(2^N)
 */
public class JumpGame {
  enum Index {
    GOOD,
    BAD,
    UNKNOWN
  }

  Index[] memo;

  public boolean canJump(int[] nums) {
    memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD;
    return canJumpFromPosition(0, nums);
  }

  public boolean canJumpFromPosition(int position, int[] nums) {
    if (memo[position] != Index.UNKNOWN) return memo[position] == Index.GOOD;
    int furthestJumpIndex = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJumpIndex; nextPosition++) {
      if (canJumpFromPosition(nextPosition, nums)) {
        memo[position] = Index.GOOD;
        return true;
      }
    }
    memo[position] = Index.BAD;
    return false;
  }
}

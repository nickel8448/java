package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/jump-game-ii/
 *
 * <p>Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to reach the last index
 * is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * <p>Approach:
 */
public class JumpGameII {
  public int jump(int[] nums) {
    int n = nums.length;
    if (n <= 1) return 0;
    int left = 0, maxJump = nums[left], right = left, jumps = 1;
    while (right < n - 1) {
      while (left <= right) {
        maxJump = Math.max(maxJump, left + nums[left]);
        left++;
      }
      if (maxJump == right) {
        return -1;
      }
      right = maxJump;
      jumps++;
    }
    return jumps;
  }

    public static void main(String[] args) {
        int[] input = {2, 3, 1, 1, 4};
        JumpGameII j = new JumpGameII();
        System.out.println(j.jump(input));
    }
}

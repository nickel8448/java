package main.java.leetcode.trees;

public class MaximumBinaryTree {
  /**
   * Problem: https://leetcode.com/problems/maximum-binary-tree/
   *
   * @param nums
   * @return
   */
  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    // This is a recursive problem
    // Use fence and post approach
    // 1. Get the maximum number and make it the root node
    // 2. Start recursion
    // 2.1 Left side recursion - find the maximum
    // 2.2 Left side recursion - Make it the root node
    // 2.3 Right side recursion - find the max
    // 2.4 right side - make the max as the root
    int maxIndex = findMaximum(nums, 0, nums.length);
    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = new TreeNode(findMaximum(nums, 0, maxIndex));
    root.right = new TreeNode(findMaximum(nums, maxIndex + 1, nums.length));
    return null;
  }

  public static int findMaximum(int[] nums, int start, int end) {
    int high = Integer.MIN_VALUE;
    for (int i = start; i < end; i++) {
      if (nums[i] > high) high = i;
    }
    return high;
  }

  public static void main(String[] args) {
    int[] input = {3, 2, 1, 6, 0, 5};
  }
}

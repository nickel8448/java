package main.java.leetcode.trees;

public class MinimumAbsoluteDifference {
  int min = Integer.MAX_VALUE;
  Integer prev = null;
  /**
   * Problem: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
   *
   * @param root
   * @return
   */
  public int getMinimumDifference(TreeNode root) {
    if (root == null) return min;
    getMinimumDifference(root.left);
    if (prev != null) min = Math.min(min, root.val - prev);
    prev = root.val;
    getMinimumDifference(root.right);
    return min;
  }
}

package main.java.leetcode.trees;

public class IsBalanced {
  /**
   * Problem: https://leetcode.com/problems/balanced-binary-tree/
   *
   * @param root
   * @return
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.abs(leftHeight - rightHeight) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right);
  }

  public int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }
}

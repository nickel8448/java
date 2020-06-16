package main.java.leetcode.trees;

public class IsCousins {
  int xDepth = -1;
  int yDepth = -1;
  TreeNode xParent;
  TreeNode yParent;

  public boolean isCousins(TreeNode root, int x, int y) {
    xDepth = getDepth(root, x, 0);
    yDepth = getDepth(root, y, 0);
    if (xDepth != yDepth) return false;
    else {
      xParent = getParent(root, x);
      yParent = getParent(root, y);
        return xParent != yParent;
    }
  }

  private TreeNode getParent(TreeNode root, int x) {
    if (root == null) return null;
    if (root.left.val == x || root.right.val == x) {
      return root;
    }
    TreeNode leftTraversal = getParent(root.left, x);
    TreeNode rightTraversal = getParent(root.right, x);
    return leftTraversal == null ? rightTraversal : leftTraversal;
  }

  public int getDepth(TreeNode root, int x, int depth) {
    if (root == null) return -1;
    if (root.val == x) return depth;
    return Math.max(getDepth(root.left, x, depth + 1), getDepth(root.right, x, depth + 1));
  }
}

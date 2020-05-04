package main.java.leetcode.trees;

public class PruneTree {
  public static TreeNode pruneTree(TreeNode root) {
    boolean isRootOne = dfsHelper(root);
    if (!isRootOne) return null;
    return root;
  }

  public static boolean dfsHelper(TreeNode node) {
    if (node == null) return true;
    if (node.left == null && node.right == null) {
      if (node.val == 0) return false;
      else return true;
    } else {
      boolean leftOne = dfsHelper(node.left);
      boolean rightOne = dfsHelper(node.right);
      if (!leftOne) node.left = null;
      if (!rightOne) node.right = null;
      if (node.val == 0 && !leftOne && !rightOne) return false;
      else return true;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);
    pruneTree(root);
  }
}

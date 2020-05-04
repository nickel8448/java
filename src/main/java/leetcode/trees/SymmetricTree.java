package main.java.leetcode.trees;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetricHelper(root.left, root.right);
  }

  public boolean isSymmetricHelper(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    } else if (l == null || r == null) {
      return false;
    }
    if (l.val != r.val) {
      return false;
    }
    return isSymmetricHelper(l.right, r.left) && isSymmetricHelper(l.left, r.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    SymmetricTree s = new SymmetricTree();
    System.out.println(s.isSymmetric(root));
  }
}

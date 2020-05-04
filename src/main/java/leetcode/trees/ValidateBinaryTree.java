package main.java.leetcode.trees;

public class ValidateBinaryTree {

  public static boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private static boolean isValidBST(TreeNode root, Integer low, Integer high) {
    if (root == null) return true;
    int val = root.val;

    if (low != null && val <= low) return false;
    if (high != null && val >= high) return false;
    return isValidBST(root.left, low, val) && isValidBST(root.right, val, high);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    System.out.println(isValidBST(root));
  }
}

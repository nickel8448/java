package main.java.leetcode.trees;

public class LowestCommonAncestor {
  /**
   * Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
   * 16/4/2020
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (q.val > p.val) return lowestCommonAncestorHelper(root, p, q);
    else return lowestCommonAncestorHelper(root, q, p);
  }

  public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (q.val >= root.val && root.val >= p.val) {
      return root;
    } else if (p.val > root.val) {
      return lowestCommonAncestorHelper(root.right, p, q);
    } else {
      return lowestCommonAncestorHelper(root.left, p, q);
    }
  }
}

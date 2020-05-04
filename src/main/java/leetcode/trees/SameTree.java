package main.java.leetcode.trees;

public class SameTree {
  /**
   * Problem: https://leetcode.com/problems/same-tree/ 4/4/2020
   *
   * @param p
   * @param q
   * @return
   */
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    return isSameTreeRec(p, q);
  }

  public static boolean isSameTreeRec(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
  }
}

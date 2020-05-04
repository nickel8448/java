package main.java.leetcode.trees;

public class MergeTwoBinaryTrees {
  public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    if (t1 == null) return t2;
    if (t2 == null) return t1;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(3);
    t1.right = new TreeNode(2);
    t1.left.left = new TreeNode(5);

    TreeNode t2 = new TreeNode(2);
    t2.left = new TreeNode(1);
    t2.right = new TreeNode(3);
    t2.left.right = new TreeNode(4);
    t2.right.right = new TreeNode(7);

    t1 = mergeTrees(t1, t2);
    System.out.println(t1.val);
    System.out.println(t1.right.val);
    System.out.println(t1.right.right.val);
    System.out.println(t1.right.left);
    System.out.println(t1.val);
    System.out.println(t1.left.val);
    System.out.println(t1.left.left.val);
    System.out.println(t1.left.right.val);
  }
}

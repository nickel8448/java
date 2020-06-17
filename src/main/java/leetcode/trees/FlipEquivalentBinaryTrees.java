package main.java.leetcode.trees;

import java.util.LinkedList;

// Questions:
// 1. Will both the trees have the same number of nodes? Assuming that they do

public class FlipEquivalentBinaryTrees {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    LinkedList<Integer> listOne = new LinkedList<>();
    LinkedList<Integer> listTwo = new LinkedList<>();
    dfs(root1, listOne);
    dfs(root2, listTwo);
    return listOne.equals(listTwo);
  }

  private void dfs(TreeNode root, LinkedList<Integer> list) {
    if (root != null) {
      list.add(root.val);
      int left = root.left != null ? root.left.val : -1;
      int right = root.right != null ? root.right.val : -1;
      if (left < right) {
        dfs(root.left, list);
        dfs(root.right, list);
      } else {
        dfs(root.right, list);
        dfs(root.left, list);
      }
      list.add(null);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(6);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(2);
    root2.left.right = new TreeNode(6);
    root2.right.left = new TreeNode(4);
    root2.right.right = new TreeNode(5);
    root2.right.right.right = new TreeNode(7);
    root2.right.right.left = new TreeNode(7);

    FlipEquivalentBinaryTrees fp = new FlipEquivalentBinaryTrees();
    fp.flipEquiv(root, root2);
  }
}

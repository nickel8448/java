package main.java.leetcode.trees;

import java.util.*;

// 1. Use combination of dfs and bfs in this case
// 2. If the algo comes across a node which is to be deleted, add that node to the queue for dfs

public class DeleteNodesAndReturnForest {
  public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> toDeleteNodes = new HashSet<>();
    for (Integer i : to_delete) {
      toDeleteNodes.add(i);
    }
    List<TreeNode> result = new ArrayList<>();
    root = dfs(root, toDeleteNodes, result);

    if (root != null) result.add(root);
    return result;
  }

  private static TreeNode dfs(TreeNode root, Set<Integer> toDeleteNodes, List<TreeNode> result) {
    if (root == null) return null;
    // case one - the node is a leaf
    if (root.left == null && root.right == null && toDeleteNodes.contains(root.val)) {
      return null;
    }

    root.left = dfs(root.left, toDeleteNodes, result);
    root.right = dfs(root.right, toDeleteNodes, result);

    if (toDeleteNodes.contains(root.val)) {
      if (root.left != null) result.add(root.left);
      if (root.right != null) result.add(root.right);
      return null;
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    int[] to_delete = {3, 5};
    List<TreeNode> result = delNodes(root, to_delete);
  }
}

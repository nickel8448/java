package main.java.leetcode.trees;

import java.util.HashMap;

public class FlipEquivalentBinaryTrees {
  public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
    HashMap<Integer, TreeNode> nodeMap = getNodeMap(root2);
    return false;
  }

  private static HashMap<Integer, TreeNode> getNodeMap(TreeNode root) {
    HashMap<Integer, TreeNode> map = new HashMap<>();
    getNodeMapHelper(map, root);
    return map;
  }

  private static void getNodeMapHelper(HashMap<Integer, TreeNode> map, TreeNode root) {
    if (root == null) return;
    getNodeMapHelper(map, root.left);
    getNodeMapHelper(map, root.right);
    map.put(root.val, root);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.right = new TreeNode(6);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(8);
    root.right.right.right = new TreeNode(7);
    flipEquiv(root, root);
  }
}

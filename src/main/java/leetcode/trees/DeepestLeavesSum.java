package main.java.leetcode.trees;

import java.util.HashMap;

public class DeepestLeavesSum {
  int maxDepth = 0;

  public int deepestLeavesSum(TreeNode root) {
    HashMap<Integer, Integer> levelSumMap = new HashMap<>();
    if (root == null) return 0;
    leavesSumHelper(root, levelSumMap, 0);
    return levelSumMap.get(maxDepth);
  }

  public void leavesSumHelper(TreeNode node, HashMap<Integer, Integer> levelSumMap, int height) {
    if (node == null) return;
    if (node.left == null && node.right == null) {
      levelSumMap.put(height, levelSumMap.getOrDefault(height, 0) + node.val);
      if (height > maxDepth) maxDepth = height;
    }
    leavesSumHelper(node.left, levelSumMap, height + 1);
    leavesSumHelper(node.right, levelSumMap, height + 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(2);
    DeepestLeavesSum ds = new DeepestLeavesSum();
    System.out.println(ds.deepestLeavesSum(root));
  }
}

package main.java.interview_prep;

import java.util.*;

/** Problem: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/ */
public class MaximumLevelSumOfABinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int maxLevelSum(TreeNode root) {
    if (root == null) return 0;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int max = Integer.MIN_VALUE;
    int maxLevel = 0;
    int level = 1;
    while (queue.size() > 0) {
      int queueSize = queue.size();
      int levelSum = 0;
      for (int i = 0; i < queueSize; i++) {
        TreeNode currentNode = queue.pollFirst();
        levelSum += currentNode.val;
        if (currentNode.left != null) queue.addLast(currentNode.left);
        if (currentNode.right != null) queue.addLast(currentNode.right);
      }
      if (levelSum > max) {
        max = levelSum;
        maxLevel = level;
      }
      level++;
    }
    return maxLevel;
  }
}

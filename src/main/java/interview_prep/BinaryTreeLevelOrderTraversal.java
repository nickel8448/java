package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * <p>Runtime: O(N)
 */
public class BinaryTreeLevelOrderTraversal {

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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      result.add(new ArrayList<>());
      int currentSize = queue.size();
      for (int i = 0; i < currentSize; i++) {
        TreeNode currentNode = queue.pollFirst();
        result.get(level).add(currentNode.val);
        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);
      }
      level++;
    }
    return result;
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * <p>Runtime: O(N)
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> output = new ArrayList<>();
    if (root == null) return output;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    queue.addLast(null);
    boolean flip = true;
    LinkedList<Integer> levelList = new LinkedList<>();
    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.pollFirst();
      if (currentNode != null) {
        if (flip) {
          levelList.addLast(currentNode.val);
        } else {
          levelList.addFirst(currentNode.val);
        }
        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);
      } else {
        // Level has finished because the loop hit NULL
        output.add(levelList);
        levelList = new LinkedList<>();
        // Adding a new NULL after the end of the current level
        if (queue.size() > 0) queue.addLast(null);
        flip = !flip;
      }
    }
    return output;
  }
}

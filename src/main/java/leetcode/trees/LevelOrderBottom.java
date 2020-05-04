package main.java.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderBottom {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Stack<List<Integer>> resultStack = new Stack<>();
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      ArrayDeque<TreeNode> tempArrayDeque = new ArrayDeque<>();
      List<Integer> tempList = new ArrayList<>();
      while (!queue.isEmpty()) {
        TreeNode topNode = queue.remove();
        tempList.add(topNode.val);
        if (topNode.left != null) {
          tempArrayDeque.add(topNode.left);
        }
        if (topNode.right != null) {
          tempArrayDeque.add(topNode.right);
        }
      }
      resultStack.push(tempList);
      queue = tempArrayDeque;
    }
    while (!resultStack.empty()) {
      result.add(resultStack.pop());
    }
    return result;
  }
}

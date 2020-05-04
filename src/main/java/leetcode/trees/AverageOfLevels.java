package main.java.leetcode.trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {
  public static List<Double> levelOrderTraversal(TreeNode root) {
    ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<>();
    List<Double> average = new LinkedList<>();
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      // Add left and right node to the queue
      ArrayDeque<TreeNode> temp = new ArrayDeque<>();
      double numElements = 0;
      double sum = 0;
      while (!nodeQueue.isEmpty()) {
        TreeNode tempNode = nodeQueue.removeFirst();
        if (tempNode.left != null) temp.add(tempNode.left);
        if (tempNode.right != null) temp.add(tempNode.right);
        sum += tempNode.val;
        numElements++;
      }
      double avg = sum / numElements;
      average.add(avg);
      nodeQueue = temp;
    }
    return average;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(10);
    root.left.right = new TreeNode(15);
    root.right = new TreeNode(7);
    root.right.right = new TreeNode(18);
    List<Double> avg = levelOrderTraversal(root);
    System.out.println(Arrays.toString(avg.toArray()));
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * <p>Runtime: O(N)
 */
public class PopulatingNextRightPointersInEachNode {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

  public Node connect(Node root) {
    Node runner = root;
    List<Node> levelList = new LinkedList<>();
    if (root == null) return null;
    LinkedList<Node> queue = new LinkedList<>();
    queue.addLast(runner);
    queue.addLast(null);
    while (!queue.isEmpty()) {
      Node currentNode = queue.pollFirst();
      if (currentNode != null) {
        levelList.add(currentNode);
        if (currentNode.left != null) queue.add(currentNode.left);
        if (currentNode.right != null) queue.add(currentNode.right);
      } else {
        // level has ended
        Node prev = levelList.get(0);
        for (int i = 1; i < levelList.size(); i++) {
          prev.next = levelList.get(i);
          prev = levelList.get(i);
        }
        levelList = new LinkedList<>();
        if (queue.size() > 0) queue.addLast(null);
      }
    }
    return root;
  }
}

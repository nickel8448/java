package main.java.leetcode.narray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new ArrayDeque<>();
    if (root == null) return result;
    queue.add(root);
    List<Integer> initialList = new ArrayList<>();
    initialList.add(root.val);
    result.add(initialList);
    while (!queue.isEmpty()) {
      Queue<Node> tempQueue = new ArrayDeque<>();
      List<Integer> toAddList = new ArrayList<>();
      while (!queue.isEmpty()) {
        Node node = queue.poll();
        for (Node child : node.children) {
          if (child != null) {
            tempQueue.add(child);
            toAddList.add(child.val);
          }
        }
      }
      queue = tempQueue;
      result.add(toAddList);
    }
    return result;
  }
}

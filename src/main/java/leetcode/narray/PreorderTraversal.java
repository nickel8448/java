package main.java.leetcode.narray;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PreorderTraversal {

  List<Integer> output = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    LinkedList<Integer> outputList = new LinkedList<>();
    LinkedList<Node> stack = new LinkedList<>();
    if (root == null) return outputList;
    stack.add(root);
    while (!stack.isEmpty()) {
      Node currentNode = stack.pollLast();
      if (currentNode.children != null) {
        Collections.reverse(currentNode.children);
        stack.addAll(currentNode.children);
      }
      outputList.add(currentNode.val);
    }
    return outputList;
  }

  /**
   * The function does a pre order traversal for a narray tree and uses queue to achieve it
   *
   * @param root
   * @return
   */
  public List<Integer> preorderQueue(Node root) {
    LinkedList<Integer> result = new LinkedList<Integer>();
    Queue<Node> queue = new ArrayDeque<>();
    if (root == null) return result;
    queue.add(root);
    return result;
  }

  public void preorderRec(Node root) {
    if (root != null) {
      output.add(root.val);
      if (root.children != null) {
        for (int i = 0; i < root.children.size(); i++) {
          preorderRec(root.children.get(i));
        }
      }
    }
  }

  public static void main(String[] args) {
    PreorderTraversal p = new PreorderTraversal();
    Node root = new Node();
    root.val = 1;
    List<Node> oneChildren = new ArrayList<>();
    oneChildren.add(new Node(3));
    oneChildren.add(new Node(2));
    oneChildren.add(new Node(4));
    root.children = oneChildren;
    List<Node> twoChildren = new ArrayList<>();
    twoChildren.add(new Node(5));
    twoChildren.add(new Node(6));
    oneChildren.get(0).children = twoChildren;
    System.out.println(p.preorder(root).toString());
  }
}

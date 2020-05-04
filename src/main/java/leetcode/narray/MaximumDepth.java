package main.java.leetcode.narray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDepth {
  public int maxDepth(Node root) {
    return maxDepthRec(root);
  }

  public int maxDepthRec(Node root) {
    if (root == null) return 0;
    if (root.children == null) return 1;
    List<Integer> childDepth = new ArrayList<>();
    for (Node child : root.children) {
      if (child != null) {
        childDepth.add(maxDepthRec(child) + 1);
      }
    }
    return Collections.max(childDepth);
  }

  public static void main(String[] args) {
    MaximumDepth p = new MaximumDepth();
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
    System.out.println(p.maxDepth(root));
  }
}

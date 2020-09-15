package main.java.leetcode.trees;

public class NodeDepths {
  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  public static int nodeDepths(BinaryTree root) {
    return nodeDepthsHelper(root, 0);
  }

  private static int nodeDepthsHelper(BinaryTree root, int currentDepth) {
    if (root == null) return 0;
    return currentDepth
        + nodeDepthsHelper(root.left, currentDepth + 1)
        + nodeDepthsHelper(root.right, currentDepth + 1);
  }
}

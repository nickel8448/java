package main.java.leetcode.trees;

public class FindClosestValue {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  static int closestvalue = 0;

  /**
   * Problem: https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
   *
   * @param tree
   * @param target
   * @return
   */
  public static int findclosestvalueinbst(BST tree, int target) {
    traverse(tree, target);
    return closestvalue;
  }

  private static void traverse(BST tree, int target) {
    if (tree != null) {
      if (Math.abs(target - closestvalue) > Math.abs(target - tree.value)) {
        closestvalue = tree.value;
      }
      if (tree.value > target) {
        traverse(tree.right, target);
      } else {
        traverse(tree.left, target);
      }
    }
  }
}

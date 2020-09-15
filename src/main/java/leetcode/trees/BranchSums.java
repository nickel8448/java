package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> result = new ArrayList<>();
    branchSumsHelper(root, result, 0);
    return result;
  }

  private static void branchSumsHelper(BinaryTree root, List<Integer> result, int currentSum) {
    if (root != null) {
      if (root.left == null && root.right == null) {
        result.add(currentSum + root.value);
      } else {
        currentSum += root.value;
        branchSumsHelper(root.left, result, currentSum);
        branchSumsHelper(root.right, result, currentSum);
      }
    }
  }
}

package main.java.interview_prep;

/**
 * Problem:
 *
 * <p>Approach:
 *
 * <p>Runtime:
 */
public class BTreeWinningMove {

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

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    if (root == null) return false;
    TreeNode xNode = findNode(root, x);
    int leftCountX = countNodes(xNode.left);
    int rightCountX = countNodes(xNode.right);
    // Objective is to find the if blocking parent (remaining), left or right
    // can help the player win
    int remainingNodes = n - leftCountX - rightCountX - 1;
    if (remainingNodes > (leftCountX + rightCountX + 1)) {
      return true;
    } else if (leftCountX > (remainingNodes + rightCountX + 1)) {
      return true;
    } else if (rightCountX > (remainingNodes + leftCountX + 1)) {
      return true;
    }
    return false;
  }

  private TreeNode findNode(TreeNode root, int x) {
    if (root == null) {
      return null;
    } else if (root.val == x) {
      return root;
    }
    TreeNode left = findNode(root.left, x);
    TreeNode right = findNode(root.right, x);
    return left == null ? right : left;
  }

  private int countNodes(TreeNode root) {
    if (root == null) return 0;
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}

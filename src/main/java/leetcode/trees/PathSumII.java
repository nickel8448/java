package main.java.leetcode.trees;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
  /**
   * Problem: https://leetcode.com/problems/path-sum-ii/
   *
   * @param root
   * @param sum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new LinkedList<>();
    pathSumHelper(root, result, new LinkedList<>(), sum);
    return result;
  }

  private void pathSumHelper(
      TreeNode root, List<List<Integer>> result, LinkedList<Integer> path, int remainingSum) {
    if (root == null) return;
    path.add(root.val);
    if (remainingSum == root.val && root.left == null && root.right == null) {
      result.add(new LinkedList<>(path));
    } else {
      pathSumHelper(root.left, result, path, remainingSum - root.val);
      pathSumHelper(root.right, result, path, remainingSum - root.val);
    }
    path.remove(path.size() - 1);
  }
}

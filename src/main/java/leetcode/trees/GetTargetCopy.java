package main.java.leetcode.trees;

public class GetTargetCopy {
  /**
   * Problem:
   * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
   *
   * @param original
   * @param cloned
   * @param target
   * @return
   */
  public static final TreeNode getTargetCopy(
      final TreeNode original, final TreeNode cloned, final TreeNode target) {
    TreeNode clonedTarget = getTargetCopyHelper(original, cloned, target);
    return clonedTarget;
  }

  public static final TreeNode getTargetCopyHelper(
      final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original == null || cloned == null) {
      return null;
    } else {
      if (cloned.val == target.val
          && cloned.left.val == target.left.val
          && cloned.right.val == target.right.val) {
        return cloned;
      }
      getTargetCopyHelper(original.left, cloned.left, target);
      getTargetCopyHelper(original.right, original.right, target);
    }
    return null;
  }

  public static void main(String[] args) {}
}

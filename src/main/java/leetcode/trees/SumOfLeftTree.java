package main.java.leetcode.trees;

public class SumOfLeftTree {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        sumOfLeftLeavesHelper(root, false);
        return sum;
    }

    public void sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
        if(root != null) {
            if(root.left == null && root.right == null && isLeft) {
                sum += root.val;
            } else {
                sumOfLeftLeavesHelper(root.left, true);
                sumOfLeftLeavesHelper(root.right, false);
            }
        }
    }
}

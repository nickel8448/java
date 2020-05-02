package main.java.leetcode.trees;

public class PathSum {
    boolean isPath = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum) return true;
        return hasPathSumHelper(root, 0, sum);
    }

    public boolean hasPathSumHelper(TreeNode node, int runningSum, int sum) {
        if(node == null) return false;
        runningSum += node.val;
        if(node.left == null && node.right == null && runningSum == sum)
            return true;
        return hasPathSumHelper(node.left, runningSum, sum) ||
            hasPathSumHelper(node.right, runningSum, sum);
    }
}

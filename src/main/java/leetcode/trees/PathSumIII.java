package main.java.leetcode.trees;

/**
 * https://leetcode.com/problems/path-sum-iii/submissions/
 */
public class PathSumIII {
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return count;
    }

    private void traverse(TreeNode root, int sum) {
        if(root == null) return;
        pathSumHelper(root, sum, 0);
        traverse(root.left, sum);
        traverse(root.right, sum);
    }

    public void pathSumHelper(TreeNode node, int sum, int runningSum) {
        if(node == null) return;
        runningSum += node.val;
        if(runningSum == sum) {
            count++;
        }
        pathSumHelper(node.left, sum, runningSum);
        pathSumHelper(node.right, sum, runningSum);
    }
}

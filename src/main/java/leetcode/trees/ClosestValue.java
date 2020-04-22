package main.java.leetcode.trees;

public class ClosestValue {
    int closestInt = 0;
    double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        double diff = Double.MAX_VALUE;
        helper(root, target);
        return closestInt;
    }

    public void helper(TreeNode root, double target) {
        if(root == null) return;
        double currentDiff = Math.abs(root.val - target);
        if(currentDiff < diff) {
            closestInt = root.val;
            diff = currentDiff;
        }
        helper(root.left, target);
        helper(root.right, target);
    }
}

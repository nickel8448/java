package main.java.leetcode.trees;

public class TiltTree {
    int result = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return result;
    }

    public int helper(TreeNode node) {
        if(node == null)
            return 0;
        int leftTilt = helper(node.left);
        int rightTilt = helper(node.right);
        result += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + node.val;
    }
}

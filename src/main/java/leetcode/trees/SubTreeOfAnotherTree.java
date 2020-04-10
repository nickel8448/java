package main.java.leetcode.trees;

/**
 * Problem: https://leetcode.com/problems/subtree-of-another-tree/
 */

public class SubTreeOfAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if((s != null && t == null) || (s == null && t != null)) {
            return false;
        }
        if(isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if ((s != null && t == null) || (s == null && t != null)) {
            return false;
        }
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) || isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode otherRoot = new TreeNode(4);
        otherRoot.left = new TreeNode(1);
        otherRoot.right = new TreeNode(2);

        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(1);

        TreeNode oneCopy = new TreeNode(1);

        System.out.println(isSubtree(one, oneCopy));
    }
}

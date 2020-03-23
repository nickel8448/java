package main.java.leetcode.trees;

public class RangeSumBST {
    static int ans;

    public static int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        sumTree(root, L, R);
        return ans;
    }

    public static int sumTree(TreeNode node, int L, int R) {
        if(node != null) {
            if(L <= node.val && node.val <= R)
                ans += node.val;
            if(node.val > L)
                sumTree(node.left, L, R);
            if(node.val < R)
                sumTree(node.right, L, R);
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(15);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 0, 15));
    }
}

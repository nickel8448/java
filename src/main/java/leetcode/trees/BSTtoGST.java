package main.java.leetcode.trees;

/**
 * Problem: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/submissions/
 */
public class BSTtoGST {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return root;
        bstToGstHelper(root);
        return root;
    }

    public void bstToGstHelper(TreeNode node) {
        if(node == null) return;
        bstToGstHelper(node.right);
        sum += node.val;
        node.val = sum;
        bstToGstHelper(node.left);
    }
}

package main.java.leetcode.trees;

public class GreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convertBSTRec(root);
        return root;
    }

    public void convertBSTRec(TreeNode root) {
        if(root != null) {
            convertBSTRec(root.right);
            sum += root.val;
            root.val = sum;
            convertBSTRec(root.left);
        }
    }

    public static void main(String[] args) {
        
    }
}

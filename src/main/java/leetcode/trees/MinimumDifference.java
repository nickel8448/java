package main.java.leetcode.trees;

import java.util.ArrayList;

public class MinimumDifference {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> intList = new ArrayList<>();
        inorderTraversal(intList, root);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < intList.size() - 1; i++) {
            int absDiff = Math.abs(intList.get(i) - intList.get(i + 1));
            if(absDiff < minDiff) {
                minDiff = absDiff;
            }
        }
        return minDiff;
    }

    public void inorderTraversal(ArrayList<Integer> intList, TreeNode node) {
        if(node == null) return;
        inorderTraversal(intList, node.left);
        intList.add(node.val);
        inorderTraversal(intList, node.right);
    }
}

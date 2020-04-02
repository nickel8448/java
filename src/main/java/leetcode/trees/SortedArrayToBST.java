package main.java.leetcode.trees;

public class SortedArrayToBST {
    /**
     * Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * 26/03/2020
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBSTRec(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = sortedArrayToBSTRec(nums, low, mid - 1);
        newNode.right = sortedArrayToBSTRec(nums, mid + 1, high);
        return newNode;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        TreeNode newNode = sortedArrayToBST(nums);
        BinaryTree bt = new BinaryTree();
        bt.inorderTraversal(newNode);
    }
}

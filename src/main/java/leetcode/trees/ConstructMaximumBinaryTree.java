package main.java.leetcode.trees;

public class ConstructMaximumBinaryTree {
    /**
     * Problem: https://leetcode.com/problems/maximum-binary-tree/submissions/
     * 30/4/2020
      * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return constructTreeFromRange(nums, 0, nums.length);
    }

    private TreeNode constructTreeFromRange(int[] nums, int left, int right) {
        if(left == right) return null;
        int maxIndex = getMaxElementIndex(nums, left, right);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructTreeFromRange(nums, left, maxIndex);
        node.right = constructTreeFromRange(nums, maxIndex + 1, right);
        return node;
    }

    private int getMaxElementIndex(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = left; i < right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTree cm =  new ConstructMaximumBinaryTree();
        TreeNode node = cm.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(node.val);
    }
}

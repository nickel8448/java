package main.java.leetcode.trees;

import java.util.*;

public class BinaryTree {
    private TreeNode root;
    private int size;

    BinaryTree(int rootVal) {
        this.root = new TreeNode(rootVal);
        size = 1;
    }

    BinaryTree() {
        root = null;
    }

    public void addNode(int val) {
        root = addNodeRec(root, val);
    }

    private TreeNode addNodeRec(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if(node.val > val) node.left = addNodeRec(node.left, val);
        if(node.val < val) node.right = addNodeRec(node.right, val);
        return node;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode node) {
        if(node != null) {
            inorderTraversal(node.left);
            System.out.println(node.val);
            inorderTraversal(node.right);
        }
    }

    /**
     * Leetcode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
     * Returns the max depth for the tree
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode node) {
        if(node == null) return 0;
        int left = maxDepth(node.left) + 1;
        int right = maxDepth(node.right) + 1;
        return Math.max(left, right);
    }

    /**
     * Leetcode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/
     * Checks if the tree is a valid binary search tree
     * Edge case was Both the left and right subtrees must also be binary search
     * trees.
     * So tree - [10,5,15,null,null,6,20] has root at 10 and 6 as a child on
     * the right which doesn't work
     * @return
     */
    public boolean isValidBST() {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;

        int val = root.val;

        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        return (isValidBST(root.left, lower, val)
                && isValidBST(root.right, val, upper));
    }

//    /**
//     * Leetcode: https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
//     * @return
//     */
//    public boolean isSymmetric() {
//        return isSymmetric(root);
//    }
//
//    private boolean isSymmetric(TreeNode root) {
//
//    }

    public List<List<Integer>> levelOrder() {
        return levelOrder(root);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outputList = new ArrayList<>();
        if(root == null) return outputList;

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        int level = 0;
        while(!nodeQueue.isEmpty()) {
            outputList.add(new ArrayList<>());
            int currentSize = nodeQueue.size();
            for (int i = 0; i < currentSize; ++i) {
                TreeNode element = nodeQueue.remove();
                outputList.get(level).add(element.val);
                if(element.left != null) nodeQueue.add(element.left);
                if(element.right != null) nodeQueue.add(element.right);
            }
            ++level;
        }
        return outputList;
    }

    public void sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return;
        root = sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBSTRec(int[] nums, int lower, int high) {
        if(lower > high) return null;
        int midIndex = lower + (high - lower) / 2;
        TreeNode newNode = new TreeNode(nums[midIndex]);
        newNode.left = sortedArrayToBSTRec(nums, lower, midIndex - 1);
        newNode.right = sortedArrayToBSTRec(nums, midIndex + 1, high);
        return newNode;
    }
}

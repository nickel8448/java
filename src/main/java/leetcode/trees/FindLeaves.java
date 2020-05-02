package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        while(root != null) {
            if(isLeave(root, leaves)) root = null;
            result.add(leaves);
            leaves = new ArrayList<>();
        }
        return result;
    }

    public static boolean isLeave(TreeNode node, List<Integer> elements) {
        if(node.left == null && node.right == null) {
            elements.add(node.val);
            return true;
        } else {
            if(node.left != null)
                if(isLeave(node.left, elements))
                    node.left = null;
            if(node.right != null)
                if(isLeave(node.right, elements))
                    node.right = null;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        System.out.println(findLeaves(root));
    }
}

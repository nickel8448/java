package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumRootToLeaf {
    /**
     * Problem: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
     * @param root
     * @return
     */
    public static int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        List<String> vals = new ArrayList<>();
        sumRootToLeafHelper(root, "", vals);
        return convertBinaryListToSum(vals);
    }

    public static void sumRootToLeafHelper(TreeNode root, String temp, List<String> vals) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            vals.add(temp + root.val);
        } else {
            StringBuilder str = new StringBuilder(temp);
            str.append(root.val);
            sumRootToLeafHelper(root.left, str.toString(), vals);
            sumRootToLeafHelper(root.right, str.toString(), vals);
            str.setLength(str.length() - 1);
        }
    }

    public static int convertBinaryListToSum(List<String> vals) {
        int sum = 0;
        for (int i = 0; i < vals.size(); i++) {
            sum += Integer.parseInt(vals.get(i), 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);
        System.out.println(sumRootToLeaf(root));
    }
}

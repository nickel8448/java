package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottomSol {
	/**
	 * Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        Collections.reverse(result);
        return result;
    }

	/**
	 * DFS helper function for level order bottom question
	 * @param root
	 * @param result
	 * @param level
	 */
    public static void dfs(TreeNode root, List<List<Integer>> result, int level) {
    	if(root == null) return;
	    if(level >= result.size()) result.add(new ArrayList<>());
    	result.get(level).add(root.val);
    	dfs(root.left, result, level + 1);
		dfs(root.right, result, level + 1);
    }

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrderBottom(root);
    }
}

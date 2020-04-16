package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>());
        return formatList(result);
    }

    private void dfs(TreeNode root, List<List<String>> result, List<String> temp) {
        if(root == null) {
            return;
        }
        else if(root.left == null && root.right == null) {
            temp.add(Integer.toString(root.val));
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        } else {
            temp.add(Integer.toString(root.val));
            dfs(root.right, result, temp);
            dfs(root.left, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private List<String> formatList(List<List<String>> result) {
        List<String> output = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < result.get(i).size(); j++) {
                str.append(result.get(i).get(j));
                if(j <= result.get(i).size() - 2)
                    str.append("->");
            }
            output.add(str.toString());
        }
        return output;
    }

    public static void main(String[] args) {
        BinaryTreePaths bt = new BinaryTreePaths();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(15);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(bt.binaryTreePaths(root));
    }
}

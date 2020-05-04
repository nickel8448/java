package main.java.leetcode.trees;

import java.util.ArrayList;

public class LeafSimilar {
  public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    ArrayList<Integer> firstList = new ArrayList<>();
    ArrayList<Integer> secondList = new ArrayList<>();
    leafList(root1, firstList);
    leafList(root2, secondList);
    return firstList.equals(secondList);
  }

  public static void leafList(TreeNode node, ArrayList<Integer> list) {
    if (node != null) {
      if (node.left == null && node.right == null) list.add(node.val);
      leafList(node.left, list);
      leafList(node.right, list);
    }
  }

  public static void main(String[] args) {}
}

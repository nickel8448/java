package main.java.leetcode.trees;

import java.util.ArrayList;
import java.util.HashSet;

public class TwoSumIV {
  public boolean findTarget(TreeNode root, int k) {
    ArrayList<Integer> values = new ArrayList<>();
    inOrder(root, values);
    HashSet<Integer> complementMap = new HashSet<>();
    for (int i = 0; i < values.size(); i++) {
      int complement = k - values.get(i);
      if (complementMap.contains(complement)) {
        return true;
      } else {
        complementMap.add(values.get(i));
      }
    }
    return false;
  }

  public void inOrder(TreeNode root, ArrayList<Integer> values) {
    if (root == null) return;
    inOrder(root.left, values);
    values.add(root.val);
    inOrder(root.right, values);
  }

  public static void main(String[] args) {}
}

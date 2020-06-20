package main.java.leetcode.trees;

public class ConvertPreorderToBST {
    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(0, preorder.length - 1, preorder);
    }

    private static TreeNode helper(int left, int right, int[] preorder) {
        if(left >= right) {
            return new TreeNode(preorder[left]);
        }
        TreeNode node = new TreeNode(preorder[left]);
        int maxIndex = findNextMaxIndex(left + 1, right, preorder, preorder[left]);
        node.left = helper(left + 1, maxIndex, preorder);
        node.right = helper(maxIndex + 1, right, preorder);
        return node;
    }

    private static int findNextMaxIndex(int left, int right, int[] preorder, int currentMax) {
        int max = currentMax;
        int maxIndex = 0;
        for(int i = left; i < right; i++) {
            if(preorder[i] > max) {
                max = preorder[i];
                maxIndex = i;
                return maxIndex;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(root.val);
        System.out.println(root.left.val);
    }
}

package main.java.LeetCode.Trees;

public class TreeNodePlayground {

    static void testSortedToBST() {
        int[] sortedArray = {-10, -3, 0, 5, 9};
        BinaryTree bt = new BinaryTree();
        bt.sortedArrayToBST(sortedArray);
        bt.inorderTraversal();
    }

    public static void main(String[] args) {
        testSortedToBST();
    }
}

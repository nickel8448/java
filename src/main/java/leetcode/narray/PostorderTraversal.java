package main.java.leetcode.narray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
    /**
     * Functions conducts a post order traversal on an n-array tree
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack =  new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null) return output;
        stack.add(root);
        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(root.val);
            for(Node child : node.children) {
                if(child != null)
                    stack.add(child);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        PostorderTraversal p = new PostorderTraversal();
        Node root = new Node();
        root.val = 1;
        List<Node> oneChildren = new ArrayList<>();
        oneChildren.add(new Node(3));
        oneChildren.add(new Node(2));
        oneChildren.add(new Node(4));
        root.children = oneChildren;
        List<Node> twoChildren = new ArrayList<>();
        twoChildren.add(new Node(5));
        twoChildren.add(new Node(6));
        oneChildren.get(0).children = twoChildren;
        System.out.println(p.postorder(root).toString());
    }
}

package main.java.leetcode.Design;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        int poppedElement = stack.pop();
        if (minStack.peek().equals(poppedElement))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

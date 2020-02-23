package main.java.leetcode.LinkedList;

public class ListNode<T> {

    private T val;
    private ListNode<T> next;

    ListNode(T x) {
        this.val = x;
    }

    T getVal() {
        return val;
    }

    void setVal(T val) {
        this.val = val;
    }

    ListNode<T> getNext() {
        return next;
    }

    void setNext(ListNode<T> next) {
        this.next = next;
    }
}


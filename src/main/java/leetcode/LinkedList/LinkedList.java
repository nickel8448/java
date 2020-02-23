package main.java.leetcode.LinkedList;

public class LinkedList<T> {

    // Default constructor
    public LinkedList() {
    }

    // Head of the LinkedList
    private ListNode<T> head;

    // Size of the Linkedlist
    private int size;

    public void add(T data) {
        if (head == null) {
            head = new ListNode<T>(data);
        } else {
            ListNode<T> currentNode = head;
            ListNode<T> toInsert = new ListNode<>(data);
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(toInsert);
        }
        ++size;
    }

    public void printList() {
        if (this.head == null)
            return;
        ListNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getVal());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                System.out.print(" -> ");
            }
        }
    }

    // Leetcode problems

    // Partition list - https://leetcode.com/problems/partition-list/
    //
    // Problem statement: Given a linked list and a value x, partition it such
    // that all nodes less than x come before nodes greater than or equal to x.
    // You should preserve the original relative order of the nodes in each of
    // the two partitions.
    //
    // Input: head = 1->4->3->2->5->2, x = 3
    // Output: 1->2->2->4->3->5

    // Reverse Linked List II
    //
    // Reverse a linked list from position m to n. Do it in one-pass
    // Input: 1->2->3->4->5->NULL, m = 2, n = 4
    // Output: 1->4->3->2->5->NULL

    public void reserveBetween(int m, int n) {
        head = reverseBetween(head, m , n);
    }

    private ListNode<T> reverseBetween(ListNode<T> head, int m, int n) {
        if (head == null)
            return null;

        ListNode<T> current = head, prev = null;
        while (m > 1) {
            prev = current;
            current = current.getNext();
            --m;
            --n;
        }
        ListNode<T> tail = current, con = prev;

        ListNode<T> next = null;
        // Reversing the list
        while(n > 0) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            --n;
        }

        if (con != null) {
            con.setNext(prev);
        } else {
            head = prev;
        }

        tail.setNext(current);
        return head;
    }

    // Given a linked list, determine if it has a cycle in it.
    //
    // To represent a cycle in the given linked list, we use an integer pos
    // which represents the position (0-indexed) in the linked list where tail
    // connects to. If pos is -1, then there is no cycle in the linked list.
    // Input: head = [3,2,0,-4], pos = 1
    // Output: true
    // Explanation: There is a cycle in the linked list, where tail connects
    // to the second node.


    public boolean hasCycle(ListNode<T> h1, int a) {
        return hasCycle(h1);
    }

    private boolean hasCycle(ListNode<T> head) {
        ListNode<T> slow = head, fast = head;
        while(slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast)
                return true;
        }
        return false;
    }
}

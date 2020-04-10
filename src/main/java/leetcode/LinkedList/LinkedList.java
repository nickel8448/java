package main.java.LeetCode.LinkedList;

import java.util.Stack;

public class LinkedList {

    // Default constructor
    public LinkedList() {
    }

    public LinkedList(int[] arr) {
        for(int num : arr) {
            this.add(num);
        }
    }

    // Head of the LinkedList
    ListNode head;

    // Size of the Linkedlist
    private int size;

    public void add(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode currentNode = head;
            ListNode toInsert = new ListNode(data);
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
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getVal());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * Problem: https://leetcode.com/problems/partition-list/
     * @param m
     * @param n
     */
    public void reserveBetween(int m, int n) {
        head = reverseBetween(head, m , n);
    }

    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;

        ListNode current = head, prev = null;
        while (m > 1) {
            prev = current;
            current = current.getNext();
            --m;
            --n;
        }
        ListNode tail = current, con = prev;

        ListNode next = null;
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


    public boolean hasCycle(ListNode h1, int a) {
        return hasCycle(h1);
    }

    private boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast)
                return true;
        }
        return false;
    }


    public void deleteNode(int value) {
        head = deleteNode(head, value);
    }


    private ListNode deleteNode(ListNode node, int value) {
        ListNode sentinel = new ListNode(0);
        ListNode current = node;
        ListNode prev = sentinel;
        ListNode next = node.next;
        sentinel.next = current;
        while(next != null) {
            if (current.val == value) {
                prev.next = next;
                current.next = null;
            } else {
                prev = current;
            }
            current = next;
            next = current.next;
        }
        return sentinel.next;
    }

    public void removeNthFromEnd(int n) {
        head = removeNthFromEndOnePass(head, n);
    }

    private ListNode removeNthFromEnd(ListNode node, int n) {
        // Get the number of nodes in the LinkedList
        int lengthOfList = 0;
        ListNode runner = node;
        while(runner != null) {
            runner = runner.next;
            ++lengthOfList;
        }
        if(lengthOfList == n) return node.next;
        int numNodesToSkip = lengthOfList - n - 1;  // Number of nodes to skip

        runner = node;
        for (int i = 0; i < numNodesToSkip; i++) {
            runner = runner.next;
        }
        if (runner.next.next != null)
            runner.next = runner.next.next;
        else
            runner.next = null;
        return head;
    }

    private ListNode removeNthFromEndOnePass(ListNode node, int n) {
        ListNode slowRunner = node;
        ListNode fastRunner = node;
        while(n != 0) {
            fastRunner = fastRunner.next;
            n--;
        }
        if(fastRunner == null) {
            return node.next;
        }
        while(fastRunner.next != null) {
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }
        if(slowRunner.next.next != null)
            slowRunner.next = slowRunner.next.next;
        else
            slowRunner.next = null;
        return node;
    }

    public void reverseLinkedList() {
        head = reverseLinkedList(head);
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode current = head, prev = null, next = head.next;
        while(next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        if(prev != null)
            current.next = prev;
        return current;
    }

    public void reverseLinkedListRec() {
        head = reverseLinkedListRecHelper(null, head);
    }

    private ListNode reverseLinkedListRecHelper(ListNode prev, ListNode curr) {
        if(curr.next == null) {
            curr.next = prev;
            return curr;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverseLinkedListRecHelper(prev, curr);
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode mergedListHead = mergedList;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            } else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList = mergedList.next;
        }
        mergedList.next = (l1 != null) ? l1 : l2;
        return mergedListHead.next;
    }

    public boolean isPalindrome() {
        return isPalindromeStack(head);
    }

    /**
     * Leetcode problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
     * @param head  Head of the list
     * @return Returns if the list is a palindrome or not
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        boolean isOdd = true;
        while(fastRunner != null && fastRunner.next != null) {
            stack.push(slowRunner.val);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if(fastRunner == null) isOdd = false;
        }
        if(isOdd) slowRunner = slowRunner.next;
        while(!stack.isEmpty() && slowRunner != null) {
            if(stack.pop() != slowRunner.val) return false;
            slowRunner = slowRunner.next;
        }
        return true;
    }

    /**
     * Leetcode problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
     * The solution below is faster in comparison to the previous one
     * @param head
     * @return
     */
    public boolean isPalindromeStack(ListNode head) {
        if(head == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode runner = head;
        while(runner != null) {
            stack.push(runner.val);
            runner = runner.next;
        }
        runner = head;
        while(runner != null) {
            if(stack.pop() != runner.val) return false;
            runner = runner.next;
        }
        return true;
    }
}

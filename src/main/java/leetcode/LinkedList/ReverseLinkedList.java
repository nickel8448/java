package main.java.leetcode.LinkedList;

public class ReverseLinkedList {
    public static void reverseList(LinkedList list) {
        list.head = reverseList(list.head);
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current.next;
        while(next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        return current;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2});
        list.printList();
        reverseList(list);
        list.printList();
    }
}

package main.java.leetcode.LinkedList;

public class LinkedListTest {

    private static void testReverseMN(LinkedList list, int m, int n) {
        System.out.println();
        list.printList();
        System.out.println("\nReversing m = " + m + " and n = " + n);
        list.reserveBetween(m, n);
        list.printList();
    }

    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode<>(10);
        a.setNext(new ListNode<>(20));
        a.getNext().setNext(new ListNode<>(30));
        a.getNext().getNext().setNext(new ListNode<>(40));
        a.getNext().getNext().getNext().setNext(new ListNode<>(50));
        LinkedList<Integer> b = new LinkedList<>();
        System.out.println(b.hasCycle(a, 2));
    }
}

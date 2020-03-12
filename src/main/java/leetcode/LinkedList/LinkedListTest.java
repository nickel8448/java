package main.java.leetcode.LinkedList;

public class LinkedListTest {

    private static void testMergedList() {
        ListNode l1 = new ListNode(1);
        l1.setNext(new ListNode(2));
        l1.next.setNext(new ListNode(4));
        ListNode l2 = new ListNode(1);
        l2.setNext(new ListNode(3));
        l2.next.setNext(new ListNode(4));
        ListNode l3 = LinkedList.mergeTwoSortedLists(l1, l2);
        while(l3 != null) {
            System.out.print(l3.val + " -> ");
            l3 = l3.next;
        }
    }

    public static void main(String[] args) {
        LinkedList palindrome = new LinkedList();
        palindrome.add(1);
        palindrome.add(3);
        palindrome.add(3);
        palindrome.add(1);
        System.out.println(palindrome.isPalindrome());
    }

}

package main.java.leetcode.LinkedList;

public class DeleteDuplicates {
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    ListNode next = current.next;
    if (next == null) return current;
    while (current != null) {
      while (next != null && current.val == next.val) {
        if (next.next == null) next = null;
        else next = next.next;
      }
      current.next = next;
      current = next;
      if (next != null) next = next.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(1);
    node.next.next = new ListNode(2);
    node.next.next.next = new ListNode(3);
    node.next.next.next.next = new ListNode(3);
    deleteDuplicates(node);
  }
}

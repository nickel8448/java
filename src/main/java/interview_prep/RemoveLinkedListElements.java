package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 *
 * <p>Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 *
 * <p>Approach: Linear
 *
 * <p>Runtime: O(N)
 */
public class RemoveLinkedListElements {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;
    ListNode previous = sentinel, current = head;
    while (current != null) {
      if (current.val == val) {
        previous.next = current.next;
      } else {
        previous = current;
      }
      current = current.next;
    }
    return sentinel.next;
  }
}

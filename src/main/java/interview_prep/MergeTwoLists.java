package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * <p>Input: Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 * <p>Runtime: O(n) Status: Time limit exceeded
 */
public class MergeTwoLists {
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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode root = new ListNode(0);
    ListNode nodeToReturn = root;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        root.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        root.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      root = root.next;
    }
    if (l1 != null) {
      root.next = l1;
    } else if (l2 != null) {
      root.next = l2;
    }
    return nodeToReturn.next;
  }
}

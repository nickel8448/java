package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * <p>Input: Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation: The
 * linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * <p>Runtime: O(n) Status: Time limit exceeded
 */
public class MergeKSortedLists {
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

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummyHead = new ListNode(0);
    ListNode headRunner = dummyHead;
    PriorityQueue<ListNode> queue =
        new PriorityQueue<>(
            new Comparator<ListNode>() {
              @Override
              public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
              }
            });
    for (ListNode head : lists) {
      if (head != null) queue.add(head);
    }
    while (!queue.isEmpty()) {
      ListNode smallestNode = queue.poll();
      headRunner.next = new ListNode(smallestNode.val);
      headRunner = headRunner.next;
      if (smallestNode.next != null) {
        queue.add(smallestNode.next);
      }
    }

    return dummyHead.next;
  }
}

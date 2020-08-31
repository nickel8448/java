package main.java.leetcode.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

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
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue =
        new PriorityQueue<>(
            lists.length,
            new Comparator<ListNode>() {
              @Override
              public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
              }
            });

    ListNode mergedListDummyHead = new ListNode(0);
    ListNode mergedListTail = mergedListDummyHead;

    for (ListNode headOfList : lists) {
      if (headOfList != null) queue.add(headOfList);
    }

    while (!queue.isEmpty()) {
      ListNode smallestNode = queue.poll();
      mergedListTail.next = smallestNode;
      mergedListTail = mergedListTail.next;
      if (smallestNode.next != null) {
        queue.add(smallestNode.next);
      }
    }
    return mergedListDummyHead.next;
  }
}

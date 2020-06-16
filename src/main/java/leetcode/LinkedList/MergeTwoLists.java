package main.java.leetcode.LinkedList;

public class MergeTwoLists {
  /** Problem: https://leetcode.com/problems/merge-two-sorted-lists/submissions/ */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode resultList = new ListNode();
    ListNode resultHead = resultList;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        resultList.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        resultList.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      resultList = resultList.next;
    }
    resultList.next = l1 == null ? l2 : l1;
    return resultHead.next;
  }
}

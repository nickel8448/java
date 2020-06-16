package main.java.leetcode.LinkedList;

import java.util.HashSet;

public class IntersectionOfLinkedList {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<Integer> setA = new HashSet<>();
    HashSet<Integer> setB = new HashSet<>();
    int counter = 0;
    while (headA != null && headB != null) {
      setA.add(headA.val);
      setB.add(headB.val);
      if (setA.contains(headB.val)) {
        return headB;
      } else if (setB.contains(headA.val)) {
        return headA;
      } else {
        headA = headA.next;
        headB = headB.next;
      }
    }
    while (headA != null) {
      if (setB.contains(headA.val)) return headA;
      headA = headA.next;
    }
    while (headB != null) {
      if (setA.contains(headB.val)) return headB;
      headB = headB.next;
    }
    return null;
  }
}

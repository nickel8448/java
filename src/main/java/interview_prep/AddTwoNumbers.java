package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 *
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 *
 * <p>Approach: Backtracking
 *
 * <p>Possible questions: 1) Can the linked lists be of different sizes? - Yes
 *
 * <p>Runtime: O(N) Because each input will create two branches
 */
public class AddTwoNumbers {
  private class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode runner = result;
    int sum = 0;
    int carryOver = 0;
    while (l1 != null || l2 != null) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;

      sum = carryOver + x + y;

      carryOver = sum / 10;
      runner.next = new ListNode(sum % 10);
      runner = runner.next;

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;

      sum = 0;
    }
    if (carryOver > 0) {
      runner.next = new ListNode(carryOver);
    }
    return result.next;
  }
}

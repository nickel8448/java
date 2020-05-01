package main.java.leetcode.LinkedList;

public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        int len = lengthOfList(head) - 1;
        int decimalValue = 0;
        while(head != null) {
            decimalValue += head.val * Math.pow(2, len);
            head = head.next;
            len--;
        }
        return decimalValue;
    }

    public int lengthOfList(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public int getDecimalValueBit(ListNode head) {
        int result = 0;
        result = (result << 1) + head.val;
        result = (result << 1) + head.next.val;
        return result;
    }

}

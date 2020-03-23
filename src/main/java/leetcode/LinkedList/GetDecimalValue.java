package main.java.leetcode.LinkedList;

public class GetDecimalValue {
    public int getDecimalValue(LinkedList list) {
        return getDecimalValueBit(list.head);
    }

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

    public static void main(String[] args) {
        int[] input = {1, 0, 1};
        LinkedList list = new LinkedList(input);
        GetDecimalValue gdv = new GetDecimalValue();
        System.out.println(gdv.getDecimalValue(list));
    }
}

package main.java.leetcode.String;

public class AddBinary {
    /**
     * Problem: https://leetcode.com/problems/add-binary/
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0)
            result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "111"));
    }
}

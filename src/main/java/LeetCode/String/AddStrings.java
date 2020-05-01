package main.java.leetcode.String;

public class AddStrings {
    /**
     * Problem: https://leetcode.com/problems/add-strings/
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += Integer.parseInt(String.valueOf(num1.charAt(i)));
                num1 = num1.substring(0, i--);
            }
            if(j >= 0) {
                sum += Integer.parseInt(String.valueOf(num2.charAt(j)));
                num2 = num2.substring(0, j--);
            }
            carry = sum / 10;
            sum %= 10;
            result.append(sum);
        }
        if(carry != 0)
            result.append(carry);
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "";
        String num2 = "9068409684984400";
        System.out.println(addStrings(num1, num2));
    }
}

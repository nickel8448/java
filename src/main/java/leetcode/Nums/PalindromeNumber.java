package main.java.leetcode.Nums;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int xCopy = x;
        int newNum = 0;
        int digit = 0;
        int counter = String.valueOf(x).length() - 1;
        while(xCopy != 0) {
            int division = (int) (xCopy / Math.pow(10, counter));
            newNum += division * Math.pow(10, digit++);
            xCopy %= Math.pow(10, counter--);
        }
        return x == newNum;
    }

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(isPalindrome(num));
    }
}

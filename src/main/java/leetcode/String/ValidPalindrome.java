package main.java.leetcode.String;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}

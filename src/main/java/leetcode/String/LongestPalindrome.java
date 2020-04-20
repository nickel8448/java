package main.java.leetcode.String;

import java.util.HashMap;

public class LongestPalindrome {
    /**
     * Problem: https://leetcode.com/problems/longest-palindrome/
     * 18/4/2020
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        int longestLength = 0;
        for(char ch : charCount.keySet()) {
            longestLength += charCount.get(ch) / 2 * 2;
            if(longestLength % 2 == 0 && charCount.get(ch) % 2 == 1)
                longestLength++;
        }
        return longestLength;
    }

    public static void main(String[] args) {

    }
}

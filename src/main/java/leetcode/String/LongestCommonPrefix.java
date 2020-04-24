package main.java.leetcode.String;

// Problem: https://leetcode.com/problems/longest-common-prefix/solution/

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"leetcode", "leet", "leed"};
        System.out.println(longestCommonPrefix(strs));
    }
}

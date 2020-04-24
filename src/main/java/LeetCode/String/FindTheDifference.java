package main.java.leetcode.String;

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        String combined = s + t;
        char diff = 0;
        for(int i = 0; i < combined.length(); i++) {
            diff ^= combined.charAt(i);
        }
        return diff;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "ae";
        System.out.println(findTheDifference(s, t));
    }
}

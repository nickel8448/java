package main.java.leetcode.String;

import java.util.HashMap;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        HashMap<Integer, Character> charMap = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isVowel(Character.toLowerCase(ch))) {
                charMap.put(++counter, ch);
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isVowel(Character.toLowerCase(ch))) {
                str.append(charMap.get(counter--));
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    public static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "eo";
        System.out.println(reverseVowels(str));
    }
}

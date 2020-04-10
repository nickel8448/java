package main.java.leetcode.String;

import java.util.HashMap;

public class ValidAnagramHashMap {
    /**
     * Problem: https://leetcode.com/problems/valid-anagram/solution/
     * 2/4/2020
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(!charMap.containsKey(ch) || charMap.get(ch) <= 0) {
                return false;
            }
            charMap.put(ch, charMap.get(ch) - 1);
        }
        for(Integer num: charMap.values()) {
            if(num != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "rat";
        String ana = "car";
        System.out.println(isAnagram(input, ana));
    }
}

package main.java.leetcode.String;

import java.util.HashMap;

public class RansomNote {
    /**
     * Problem: https://leetcode.com/problems/ransom-note/
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if(countMap.containsKey(ch))
                countMap.put(ch, countMap.get(ch) - 1);
        }
        for(char ch : countMap.keySet()) {
            if(countMap.get(ch) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String note = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(note, magazine));
    }
}

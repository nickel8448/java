package main.java.leetcode.String;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/

import java.util.Arrays;
import java.util.HashMap;

public class FirstUniqueCharacter {

    public static int firstUniqueChar(String s) {
        int[] tracker = new int[26];
        Arrays.fill(tracker, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';
            if(tracker[charIndex] == -1) tracker[charIndex] = i;
            else if (tracker[charIndex] >= 0) tracker[charIndex] = -2;
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < tracker.length; i++) {
            if(minIndex > tracker[i] && tracker[i] >= 0) minIndex = tracker[i];
        }
        return (minIndex==Integer.MAX_VALUE) ? -1 : minIndex;
    }

//    public static int firstUniqueChar(String s) {
//        HashMap<Character, Integer> characterMap = new HashMap<>();
//        int index = 0;
//        for(int i = 0; i < s.length(); ++i) {
//            char c = s.charAt(i);
//            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if(characterMap.get(s.charAt(i)) == 1) return i;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("loveleetcode"));
    }
}

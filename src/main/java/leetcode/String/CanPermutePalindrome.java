package main.java.leetcode.String;

import java.util.HashMap;

public class CanPermutePalindrome {
    static int numCalls = 0;
    public static boolean canPermutePalindrome(String s) {
        if(s.length() ==0) return true;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int numOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charMap.put(currentChar,
                    charMap.getOrDefault(currentChar, 0) + 1);
            if(charMap.get(s.charAt(i)) % 2 == 0) numOdd--;
            else numOdd++;
        }
        if(s.length() % 2 == 0 && numOdd == 0) return true;
        else return s.length() % 2 != 0 && numOdd == 1;
    }

    public static void permutateString(String prefix, String str) {
        if(str.length() == 0) System.out.println(prefix);;
        for(int i = 0; i < str.length(); i++) {
            permutateString(prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1));
        }
    }

    public static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("AaBb//a"));
    }
}

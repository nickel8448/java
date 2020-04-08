package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String str) {
        List<String> out = new ArrayList<>();
        letterCasePermutationUtil(out, 0, str);
        return out;
    }

    public static void letterCasePermutationUtil(List<String> list, int index, String str) {
        if(index == str.length()) {
            list.add(str);
            return;
        }
        if(Character.isLetter(str.charAt(index))) {
            StringBuilder temp = new StringBuilder(str);
            temp.setCharAt(index, Character.toUpperCase(str.charAt(index)));
            letterCasePermutationUtil(list, index + 1, temp.toString());
            temp.setCharAt(index, Character.toLowerCase(str.charAt(index)));
            letterCasePermutationUtil(list, index + 1, temp.toString());
        } else {
            letterCasePermutationUtil(list, index + 1, str);
        }
    }

    public static void main(String[] args) {
        String input = "a1b2";
        System.out.println(letterCasePermutation(input));
    }
}

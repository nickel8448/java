package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    /**
     * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        String[] letters = initializeLetters();
        int[] digitsArr = initializeDigitsArr(digits);
        List<String> result = new ArrayList<>();
        letterCombinationsHelper(result, "", digitsArr, letters, 0);
        return result;
    }

    public static void letterCombinationsHelper(List<String> result,
            String temp, int[] digitsArr, String[] letters, int index) {
        if(temp.length() == digitsArr.length) {
            result.add(temp);
        } else {
            String currentDigits = letters[digitsArr[index] - 2];
            for(int i = 0; i < currentDigits.length(); i++) {
                StringBuilder str = new StringBuilder(temp);
                str.append(currentDigits.charAt(i));
                letterCombinationsHelper(result, str.toString(), digitsArr,
                        letters, index + 1);
                str.setLength(str.length() - 1);
            }
        }
    }

    public static int[] initializeDigitsArr(String digits) {
        int[] result = new int[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
            result[i] = Character.getNumericValue(digits.charAt(i));
        }
        return result;
    }

    public static String[] initializeLetters() {
        return new String[]{
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
    }

    public static void main(String[] args) {
        String input = "237";
        System.out.println(letterCombinations(input));
    }
}

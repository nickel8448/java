package main.java.interview_prep;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * <p>Sample test: Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * <p>Approach: Backtracking
 *
 * <p>Runtime: O(3^n * 4^M) where N is the number of digits in the input that 
 * maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in 
 * the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number 
 * digits in the input.
 */

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        String[] numberMapping = getNumberMapping();
        StringBuilder text = new StringBuilder();
        backtrack(digits, numberMapping, 0, text, result);
        return result;
    }

    private void backtrack(String digits, String[] numberMapping, int index, StringBuilder text, List<String> result) {
        if (text.length() == digits.length()) {
            result.add(text.toString());
        } else {
            int numberIndex = Character.getNumericValue(digits.charAt(index)) - 2;
            String chars = numberMapping[numberIndex];
            for (int i = 0; i < chars.length(); i++) {
                text.append(chars.charAt(i));
                backtrack(digits, numberMapping, index + 1, text, result);
                text.setLength(text.length() - 1);
            }
        }
    }

    private String[] getNumberMapping() {
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
}

package main.java.leetcode.Backtracking;

import java.util.List;
import java.util.ArrayList;

public class PalindromeParition {
    public static List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(result, new ArrayList<>(), 0, str);
        return result;
    }

    public static void partitionHelper(List<List<String>> result,
                                       List<String> runningList,
                                       int index,
                                       String str) {
        if(index == str.length()) {
            result.add(new ArrayList<>(runningList));
        } else {
            for(int i = index; i < str.length(); i++) {
                if(isPalindrome(str, index, i)) {
                    String palindromeString = str.substring(index, i + 1);
                    runningList.add(palindromeString);
                    partitionHelper(result, runningList, i + 1, str);
                    runningList.remove(runningList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String str, int left, int right) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aab";
        partition(str);
    }
}
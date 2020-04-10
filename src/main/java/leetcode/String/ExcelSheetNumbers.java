package main.java.leetcode.String;

public class ExcelSheetNumbers {
    /**
     * https://leetcode.com/problems/excel-sheet-column-number/
     * 3/4/2020
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }
}

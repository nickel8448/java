package main.java.LeetCode.Array;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] out = new int[n+1];
        out[0] = 1;
        return out;
    }

    public static void main(String[] args) {
        int []digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}

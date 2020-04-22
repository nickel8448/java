package main.java.leetcode.Array;

import java.util.Arrays;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                for(int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        duplicateZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}

package main.java.leetcode.Array;


// TODO: Check how can swaps be done with Java native commands

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int []outputArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % (nums.length);
            outputArray[index] = nums[i];
        }
        for(int i = 0; i < nums.length; ++i) {
            nums[i] = outputArray[i];
        }
    }

    public static void main(String[] args) {
        int []num1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(num1));
        rotate(num1, 3);
        System.out.println(Arrays.toString(num1));
    }
}

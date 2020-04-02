package main.java.leetcode.Array;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        int[] input2 = {0, 1};
        int[] input3 = {2, 1};
        int[] input4 = {1, 0, 1};
        moveZeroes(input);
        moveZeroes(input2);
        moveZeroes(input3);
        moveZeroes(input4);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(input3));
        System.out.println(Arrays.toString(input4));
    }
}

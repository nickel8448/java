package main.java.leetcode.Array;

// Given a sorted array nums, remove the duplicates in-place such that each
// element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this by modifying
// the input array in-place with O(1) extra memory.
// Example 1:
// Given nums = [1,1,2],
// Your function should return length = 2, with the first two elements of nums
// being 1 and 2 respectively.
// It doesn't matter what you leave beyond the returned length.

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSorted {
    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
        int newLength = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!elements.contains(nums[i])) {
                elements.add(nums[i]);
                nums[counter++] = nums[i];
            }
        }
        return elements.size();
    }

    public static void main(String[] args) {
        int []a = {1, 1, 2};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        int []b = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(b));
        System.out.println(Arrays.toString(b));
        int []c = {1, 2, 3, 4};
        System.out.println(removeDuplicates(c));
        System.out.println(Arrays.toString(c));
    }
}

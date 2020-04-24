package main.java.sorting;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = m + n - 1;
        int pointer3 = n - 1;
        while((pointer1 >= 0) && (pointer3 >= 0)) {
            if(nums2[pointer3] > nums1[pointer1]) {
                nums1[pointer2--] = nums2[pointer3--];
            } else {
                nums1[pointer2--] = nums1[pointer1--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, pointer3 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

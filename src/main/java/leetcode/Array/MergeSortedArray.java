package main.java.leetcode.Array;

import java.util.Arrays;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // fill the nums1 array with nums2 elements
    int counter = 0;
    for (int i = 0; i < n; i++) {
      nums1[i + m] = nums2[counter++];
    }
    counter = 0;
    while (n < nums1.length && counter < n) {
      if (nums1[counter] <= nums1[n]) {
        counter++;
      } else {
        if (counter < m) {
          int temp = nums1[counter];
          nums1[counter] = nums1[n];
          nums1[n] = temp;
          n++;
          counter++;
        } else {
          n++;
        }
      }
    }
  }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        m.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

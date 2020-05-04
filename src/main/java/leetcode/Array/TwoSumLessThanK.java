package main.java.leetcode.Array;

import java.util.Arrays;

public class TwoSumLessThanK {
  public static int twoSumLessThanK(int[] A, int K) {
    int max = -1;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        int sum = A[i] + A[j];
        if (sum > max && sum < K) {
          max = sum;
        }
      }
    }
    return max;
  }

  public static int twoSumLessThanKHeap(int[] arr, int K) {
    Arrays.sort(arr);
    int max = -1;
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (arr[right] > K) {
        right--;
      } else if (max < sum && sum < K) {
        max = sum;
      } else if (sum >= max) {
        right--;
      } else {
        left++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] A = {34, 23, 1, 24, 75, 33, 54, 8};
    System.out.println(twoSumLessThanKHeap(A, 60));
  }
}

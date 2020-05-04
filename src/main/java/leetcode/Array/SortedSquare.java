package main.java.leetcode.Array;

import java.util.Arrays;

public class SortedSquare {
  public static int[] sortedSquares(int[] arr) {
    if (arr.length == 0) return arr;
    // 1. Find the element which is the centre
    int low = 0;
    int high = arr.length - 1;
    int centerElement = 0;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] >= 0) high = mid;
      else low = mid + 1;
    }
    centerElement = low;
    int[] outputArray = new int[arr.length];
    int negativeCounter = centerElement - 1;
    int positiveCounter = centerElement;
    for (int i = 0; i < arr.length; i++) {
      if (negativeCounter >= 0 && (Math.abs(arr[negativeCounter]) <= arr[positiveCounter])) {
        outputArray[i] = (int) Math.pow(arr[negativeCounter--], 2);
      } else if (positiveCounter < arr.length) {
        outputArray[i] = (int) Math.pow(arr[positiveCounter++], 2);
      }
    }
    return outputArray;
  }

  public static void main(String[] args) {
    int[] ar = {-2, 0};
    int[] arr = {-4, -1, 0, 3, 10};
    int[] arr2 = {-7, -3, 2, 3, 11};
    System.out.println(Arrays.toString(sortedSquares(arr)));
    System.out.println(Arrays.toString(sortedSquares(arr2)));
    System.out.println(Arrays.toString(sortedSquares(ar)));
  }
}

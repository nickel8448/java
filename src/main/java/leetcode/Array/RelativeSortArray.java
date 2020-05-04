package main.java.leetcode.Array;

import java.util.Arrays;

public class RelativeSortArray {
  public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    int sortedIndex = 0;
    for (int i = 0; i < arr2.length; i++) {
      for (int j = sortedIndex; j < arr1.length; j++) {
        if (arr2[i] == arr1[j]) {
          swapElement(arr1, j, sortedIndex);
          sortedIndex++;
        }
      }
    }
    return arr1;
  }

  public static void swapElement(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void main(String[] args) {
    int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = {2, 1};
    System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
  }
}

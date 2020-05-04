package main.java.leetcode.DivideAndConq;

import java.util.Arrays;

public class MergeSort {

  public static void Sort(int[] arr) {
    Sort(arr, 0, arr.length - 1);
  }

  public static void Sort(int[] arr, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      // sort left
      // sort right
      // merge
      Sort(arr, low, mid);
      Sort(arr, mid + 1, high);
      Merge(arr, low, mid, high);
    }
  }

  public static void Merge(int[] arr, int low, int mid, int high) {
    int leftLength = mid - low + 1;
    int rightLength = high - mid;

    int[] leftArr = new int[leftLength];
    int[] rightArr = new int[rightLength];

    // Filling left array
    for (int i = 0; i < leftLength; i++) {
      leftArr[i] = arr[low + i];
    }
    for (int i = 0; i < rightLength; i++) {
      rightArr[i] = arr[mid + i + 1];
    }

    int leftCounter = 0;
    int rightCounter = 0;
    int outputCounter = low;

    while (leftCounter < leftLength && rightCounter < rightLength) {
      if (leftArr[leftCounter] < rightArr[rightCounter]) {
        arr[outputCounter++] = leftArr[leftCounter++];
      } else {
        arr[outputCounter++] = rightArr[rightCounter++];
      }
    }

    while (leftCounter < leftLength) {
      arr[outputCounter++] = leftArr[leftCounter++];
    }
    while (rightCounter < rightLength) {
      arr[outputCounter++] = rightArr[rightCounter++];
    }
  }

  public static void main(String[] args) {
    int[] input = {5, 2, 3, 1, 0, 6};
    Sort(input);
    System.out.println(Arrays.toString(input));
  }
}

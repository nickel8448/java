package main.java.leetcode.Array;

import java.util.Arrays;

public class SortArrayByParity {
  public static int[] sortArrayByParity(int[] arr) {
    if (arr.length == 0) return arr;
    int startCounter = 0;
    int evenNumCounter = 0;
    while (evenNumCounter != arr.length) {
      if (arr[evenNumCounter] % 2 == 0) {
        int temp = arr[startCounter];
        arr[startCounter++] = arr[evenNumCounter];
        arr[evenNumCounter] = temp;
      }
      evenNumCounter++;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2};
    System.out.println(Arrays.toString(sortArrayByParity(nums)));
  }
}

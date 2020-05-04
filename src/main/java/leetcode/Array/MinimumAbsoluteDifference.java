package main.java.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
  /**
   * Problem: https://leetcode.com/problems/minimum-absolute-difference/ 9/4/2020
   *
   * @param arr
   * @return
   */
  public static List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int minDifference = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      minDifference = Math.min(minDifference, Math.abs(arr[i] - arr[i - 1]));
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i < arr.length; i++) {
      if (Math.abs(arr[i] - arr[i - 1]) == minDifference) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[i - 1]);
        list.add(arr[i]);
        result.add(list);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] input = {3, 8, -10, 23, 19, -4, -14, 27};
    minimumAbsDifference(input);
  }
}

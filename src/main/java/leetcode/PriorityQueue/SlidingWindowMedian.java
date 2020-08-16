package main.java.leetcode.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlidingWindowMedian {
  public double[] medianSlidingWindow(int[] nums, int k) {
    List<Double> result = new ArrayList<>();
    int start = 0;
    int end = k - 1;
    while (end != nums.length) {
      List<Integer> currentList = new ArrayList<>();
      for (int i = start; i <= end; i++) {
        currentList.add(nums[i]);
      }
      Collections.sort(currentList);
      if (currentList.size() % 2 == 1) {
        result.add((double) currentList.get(currentList.size() / 2));
      } else {
        double firstElement = (double) currentList.get(currentList.size() / 2);
        double secondElement = (double) currentList.get(currentList.size() / 2 - 1);
        double median = (firstElement + secondElement) / 2;
        result.add(median);
      }
      start++;
      end++;
    }
    double[] medians = new double[result.size()];
    for (int i = 0; i < result.size(); i++) {
      medians[i] = result.get(i);
    }
    return medians;
  }

  public static void main(String[] args) {
    SlidingWindowMedian s = new SlidingWindowMedian();
    int[] input = { 1, 3, -1, -3, 5, 3, 6, 7 };
    System.out.println(Arrays.toString(s.medianSlidingWindow(input, 3)));
  }
}

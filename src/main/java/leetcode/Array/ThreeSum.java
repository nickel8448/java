package main.java.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> outputList = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      int totalSum = 0;
      int counter = 0;
      List<Integer> tempList = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        if (i + j < nums.length - 1) {
          tempList.add(nums[i + j]);
          totalSum += nums[i + j];
        }
        counter++;
      }
      if (totalSum == 0 && counter == 3) {
        outputList.add(tempList);
      }
    }
    return outputList;
  }

  public static List<List<Integer>> threeSumOptimized(int[] nums) {
    int[] sortedArray = nums.clone();
    Arrays.sort(sortedArray);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < sortedArray.length; i++) {
      if (i == 0 || sortedArray[i] != sortedArray[i - 1]) {
        twoSum(sortedArray, i, result);
      }
    }
    return result;
  }

  private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
    int left = i + 1, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right] + nums[i];
      if (sum < 0 || (left > i + 1 && nums[left] == nums[left - 1])) {
        left++;
      } else if (sum > 0 || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
        right--;
      } else {
        List<Integer> temp = Arrays.asList(nums[i], nums[left], nums[right]);
        result.add(temp);
        left++;
        right--;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> list = threeSumOptimized(nums);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(Arrays.toString(list.get(i).toArray()));
    }
  }
}

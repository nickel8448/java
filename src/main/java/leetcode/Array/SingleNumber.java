package main.java.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> numCount = new HashMap<>();
    for (int x : nums) {
      if (numCount.containsKey(x)) {
        numCount.replace(x, numCount.get(x) + 1);
      } else {
        numCount.put(x, 1);
      }
    }
    int numToReturn = 0;
    for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
      if (entry.getValue() == 1) {
        numToReturn = entry.getKey();
      }
    }
    return numToReturn;
  }

  public static int singleNumberXor(int[] nums) {
    int output = nums[0];
    for (int i = 1; i < nums.length; i++) {
      output ^= nums[i];
    }
    return output;
  }

  public static void main(String[] args) {
    int[] nums = {4, 1, 2, 1, 2};
    System.out.println(singleNumberXor(nums));
  }
}

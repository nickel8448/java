package main.java.interview_prep;

import java.util.HashSet;
import java.util.Set;

/** Problem: https://leetcode.com/problems/first-missing-positive/ */
public class FirstMissingPositive {
  /**
   * The approach is to use sets - The first positive number has to be maximum n + 1. The numbers in
   * the array can best be 1 - 7 in an array of size 6. Keep adding numbers to the set and the first
   * missing number in the set is the answer or the length of the array + 1
   *
   * @param nums
   * @return
   */
  public int firstMissingPositiveUsingSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    for (int i = 1; i < nums.length + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return nums.length + 1;
  }

  /**
   * The approach involves a few steps
   * 1) Convert all numbers > n + 1 || nums[i] <= 0 by 1 
   * [3, 4, -1, 0, 1, 10]
   * [3, 4, 1, 1, 1, 1] 
   * 2) Retireve the number at nums[i] - 1 and mark that as negative
   * [3, 4, -1, 1, 1, 1]
   * [3, 4, -1, -1, 1, 1]
   * [-3, 4, -1, -1, 1, 1]
   * If the number is already at the index is already negative do
   * nothing If num[i] is negative take the abs and
   *
   * [1, 2, 0]
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
  	boolean containsOne = false;
  	for(int i = 0; i < nums.length; i++) {
  		if (nums[i] == 1) {
  			containsOne = true;
  		}
  	}
  	if (!containsOne)
  		return 1;
  	int n = nums.length;
  	if (n == 1)
  		return 2;
    // convert all the numbers > n || n <= 0 by 1
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > n || nums[i] <= 0) {
        nums[i] = 1;
      }
    }
    // step 2 - marking the number retrieved at the current index as negative
    for (int i = 0; i < nums.length; i++) {
      int indexToTurnNegative = Math.abs(nums[i]) - 1;
      if (nums[indexToTurnNegative] > 0)
      	nums[indexToTurnNegative] = -nums[indexToTurnNegative];
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }
}

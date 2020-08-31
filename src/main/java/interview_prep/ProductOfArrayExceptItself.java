package main.java.interview_prep;

/**
 * Problem: https://leetcode.com/problems/product-of-array-except-self/Spi
 *
 * Sample test:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Input: [3, 2]
 * Output: [3, 2]
 * 
 * Approach:
 * Maintain a prefix and a suffix array with multiplcations
 * 
 * Runtime: O(3n) -> O(n)
 * Space complexity: O(3n)
 */
public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        // fill the suffix and the prefix array
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];  // [3, ]
            } else {
                prefix[i] = nums[i] * prefix[i - 1];  // [3, 6]
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffix[i] = nums[i];  // [, 2]
            } else {
                suffix[i] = nums[i] * suffix[i + 1];  // [6, 2]
            }
        }

        // Fill in a new array with values
        // prefix[i - 1] * suffix [i + 1]
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = suffix[i + 1];  // [24, 12, 8, 6]
            } else if (i == nums.length - 1) {
                result[i] = prefix[i - 1];  // [24, 12, 8, 6]
            } else {
                result[i] = prefix[i - 1] * suffix[i + 1];  // [24, 12, 8, 6]
            }
        }
        return result;
    }
}

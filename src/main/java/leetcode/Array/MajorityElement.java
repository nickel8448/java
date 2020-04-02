package main.java.leetcode.Array;

public class MajorityElement {
    /**
     * Problem: https://leetcode.com/problems/majority-element/
     * 27/3/2020
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int currentElement = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != currentElement) {
                count--;
            } else if(nums[i] == currentElement) {
                count++;
            }
            if (count < 0) {
                currentElement = nums[i];
                count = 0;
            }
        }
        return currentElement;
    }

    public static int majorityElementDC(int[] nums) {
        return majorityElementDCRec(nums, 0, nums.length - 1);
    }

    public static int majorityElementDCRec(int[] nums, int low, int high) {
        if(low == high) return nums[low];
        int mid = low + (high - low) / 2;
        int left = majorityElementDCRec(nums, low, mid);
        int right = majorityElementDCRec(nums, mid + 1, high);

        // If left and right have the same element
        if (left == right) return left;

        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    public static int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for(int i = low; i < high; i++) {
            if(nums[i] == num) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 3, 1, 2};
        System.out.println(majorityElementDC(nums));
    }
}

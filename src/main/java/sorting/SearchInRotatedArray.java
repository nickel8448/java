package main.java.sorting;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        // Search for the smallest element
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int midPoint = left + (right - left) / 2;
            if(nums[midPoint] > nums[right]) left = midPoint + 1;
            else right = midPoint;
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while(left <= right) {
            int midPoint = left + (right - left) / 2;
            if(nums[midPoint] == target) return midPoint;
            else if(nums[midPoint] < target) left = midPoint + 1;
            else right = midPoint - 1;
        }
        return -1;
    }

    public static void main(String []args) {
        int[] nums = {4, 5, 6, 7, 1, 2};
        System.out.println(search(nums, 1));
    }
}

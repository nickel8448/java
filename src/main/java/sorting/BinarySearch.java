package main.java.sorting;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    public static int searchHelper(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int midPoint = left + (right - left) / 2;
            if (nums[midPoint] == target) return midPoint;
            if (nums[midPoint] > target)
                return searchHelper(nums, left, midPoint - 1, target);
            return searchHelper(nums, midPoint + 1, right, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 90));
    }
}

package main.java.sorting;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int left, int right) {
        if(left == right) return left;
        int midPoint = left + (right - left) / 2;
        if(nums[midPoint] > nums[midPoint + 1])
            return search(nums, left, midPoint);
        return search(nums, midPoint + 1, right);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}

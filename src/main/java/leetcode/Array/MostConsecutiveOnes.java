package main.java.leetcode.Array;

public class MostConsecutiveOnes {
    /**
     * Problem: https://leetcode.com/problems/max-consecutive-ones/
     * 8/4/2020
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int mostConsecutive = 0;
        int currentCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currentCount++;
                if(currentCount > mostConsecutive) {
                    mostConsecutive = currentCount;
                }
            } else if(nums[i] == 0) {
                currentCount = 0;
            }
        }
        return mostConsecutive;
    }

    public static void main(String[] args) {
        int[] input = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(input));
    }
}

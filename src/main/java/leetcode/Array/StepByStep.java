package main.java.leetcode.Array;

public class StepByStep {
    /**
     * Leetcode biweekly content first question
     * 18/4/2020
     * @param nums
     * @return
     */
    public static int minStartValue(int[] nums) {
        int startValue = 1;
        while(true) {
            int onGoingNum = startValue;
            boolean checked = false;
            for(int i = 0; i < nums.length; i++) {
                onGoingNum += nums[i];
                if (onGoingNum < 1) {
                    startValue++;
                    break;
                }
                if(i == nums.length - 1) {
                    checked = true;
                }
            }
            if(checked) break;
        }
        return startValue;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,-5,-1};
        System.out.println(minStartValue(nums));
    }
}

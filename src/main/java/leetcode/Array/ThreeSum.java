package main.java.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i) {
            int totalSum = 0;
            int counter = 0;
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if(i + j < nums.length - 1) {
                    tempList.add(nums[i + j]);
                    totalSum += nums[i + j];
                }
                counter++;
            }
            if(totalSum == 0 && counter == 3) {
                outputList.add(tempList);
            }
        }
        return outputList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}

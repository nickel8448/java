package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, result, new ArrayList<>(), 0,0);
        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target,
                                            List<List<Integer>> result,
                                            List<Integer> temp,
                                            int index,
                                            int ongoingSum) {
        if (ongoingSum == target) {
            result.add(new ArrayList<>(temp));
        } else if (ongoingSum > target) {
            return;
        } else {
            for(int i = index; i < candidates.length; i++) {
                if(candidates[i] != 0) {
                    ongoingSum += candidates[i];
                    temp.add(candidates[i]);
                    combinationSumHelper(candidates, target, result, temp, i,
                            ongoingSum);
                    temp.remove(temp.size() - 1);
                    ongoingSum -= candidates[i];
                }
            }
        }
    }

    

    public static void main(String[] args) {
        int[] candidate = {0, 1};
        int target = 8;
        System.out.println(combinationSum(candidate, target));
    }
}

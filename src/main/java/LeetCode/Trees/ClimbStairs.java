package main.java.leetcode.trees;

public class ClimbStairs {
    public static int climbStairs(int n) {
        int oneSteps = climbStairs(1, n, 0);
        int twoSteps = climbStairs(2, n, 0);
        return oneSteps + twoSteps;
    }

    public static int climbStairs(int stepValue, int pendingSteps, int numSteps) {
        if(pendingSteps <= 0) return numSteps;
        int oneSteps = climbStairs(1, pendingSteps - 1, numSteps + 1);
        int twoSteps = climbStairs(2, pendingSteps - 2, numSteps + 1);
        return oneSteps + twoSteps;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

}

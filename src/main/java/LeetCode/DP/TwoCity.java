package main.java.leetcode.DP;

public class TwoCity {
    public int twoCitySchedCost(int[][] costs) {
        int aPending = costs.length / 2;
        int bPending = costs.length / 2;
        int minCost = 0;
        for(int i = 0; i < costs.length; i++) {
            if(costs[i][0] < costs[i][1] && aPending >= 0) {
                minCost += costs[i][0];
                aPending--;
            } else if(costs[i][1] < costs[i][0] && bPending >= 0) {
                minCost += costs[i][1];
                bPending--;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {

    }
}

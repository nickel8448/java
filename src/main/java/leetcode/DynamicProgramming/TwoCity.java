package main.java.leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCity {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int aPending = costs.length / 2;
        int bPending = costs.length / 2;
        int minCost = 0;
        for(int i = 0; i < costs.length; i++) {
            if(i < costs.length / 2) {
                minCost += costs[i][0];
            } else {
                minCost += costs[i][1];
            }
        }
        return minCost;
    }

    public static void main(String[] args) {

    }
}

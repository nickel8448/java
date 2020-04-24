package main.java.leetcode.Array;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            else if(prices[i] - min > max)
                max = prices[i] - min;
        }
        return max;
    }

    public static int maxProfitRec(int[] prices, int left, int right) {
        if(left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftProfit = maxProfitRec(prices, left, mid);
        int rightProfit = maxProfitRec(prices, mid + 1, right);
        int crossProfit = crossProfit(prices, left, right);
        int maxLeftAndRight = Math.max(leftProfit, rightProfit);
        return Math.max(crossProfit, maxLeftAndRight);
    }

    public static int crossProfit(int[] prices, int left, int right) {
        int max = 0;
        for(int i = left; i <= right; i++) {
            for(int j = i + 1; j <= right; j++) {
                if(j < prices.length) {
                    if(prices[j] - prices[i] > max)
                        max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public static void main(String []args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

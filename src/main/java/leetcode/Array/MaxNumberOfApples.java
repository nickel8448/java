package main.java.leetcode.Array;

import java.util.Arrays;

public class MaxNumberOfApples {
    /**
     * Problem: https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
     * @param arr
     * @return
     */
    public static int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int maxWeight = 5000;
        int totalWeight = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] + totalWeight <= maxWeight) {
                count++;
                totalWeight += arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {100, 200, 150, 1000};
        int[] input2 = {900,950,800,1000,700,800};
        int[] input3 = {5100, 6000};
        System.out.println(maxNumberOfApples(input));
        System.out.println(maxNumberOfApples(input2));
        System.out.println(maxNumberOfApples(input3));
    }
}

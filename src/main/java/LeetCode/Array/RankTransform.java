package main.java.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransform {
    /**
     * Problem: https://leetcode.com/problems/rank-transform-of-an-array/
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);
        int rankCounter = 0;
        HashMap<Integer, Integer> sortedIndexMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!sortedIndexMap.containsKey(sortedArray[i]))
                sortedIndexMap.put(sortedArray[i], rankCounter++);
        }
        int[] resultArray = new int[arr.length];
        for(int i = 0; i < sortedArray.length; i++) {
            resultArray[i] = sortedIndexMap.get(arr[i]) + 1;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}

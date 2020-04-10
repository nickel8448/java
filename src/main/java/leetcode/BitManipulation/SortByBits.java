package main.java.leetcode.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortByBits {
    /**
     * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
     * 8/4/2020
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> bitsToNumMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int bits = numOneBits(arr[i]);
            if(bitsToNumMap.containsKey(bits)) {
                ArrayList<Integer> temp = bitsToNumMap.get(bits);
                temp.add(arr[i]);
                bitsToNumMap.put(bits, temp);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                bitsToNumMap.put(bits, list);
            }
        }
        int[] bitsArr = new int[bitsToNumMap.size()];
        int counter = 0;
        for(int key : bitsToNumMap.keySet()) {
            bitsArr[counter++] = key;
        }
        Arrays.sort(bitsArr);
        int[] outArr = new int[arr.length];
        int outCounter = 0;
        for(int i = 0; i < bitsArr.length; i++) {
            ArrayList<Integer> temp = bitsToNumMap.get(bitsArr[i]);
            Collections.sort(temp);
            for (Integer integer : temp) {
                outArr[outCounter++] = integer;
            }
        }
        return outArr;
    }

    /**
     * Functions counts the number of 1 bits in an integer
     * @param num
     * @return
     */
    public static int numOneBits(int num) {
        int temp = num;
        int numBits = 0;
        while(temp != 0) {
            if((temp & 1) == 1) numBits++;
            temp >>= 1;
        }
        return numBits;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
}

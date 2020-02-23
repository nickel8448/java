package main.java.leetcode.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int []nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int x: nums) {
            if (numCount.containsKey(x)) {
                numCount.replace(x, numCount.get(x) + 1);
            } else {
                numCount.put(x, 1);
            }
        }
        int numToReturn = 0;
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            if (entry.getValue() == 1) {
                numToReturn = entry.getKey();
            }
        }
        return numToReturn;
    }
}

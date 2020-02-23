package main.java.leetcode.Array;


import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] num1, int[] num2) {
        if(num1.length > num2.length) intersect(num2, num1);
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : num1) m.put(n, m.getOrDefault(n, 0) + 1);
        int k = 0;
        for (int n : num2) {
            int count = m.getOrDefault(n, 0);
            if (count > 0) {
                num1[k++] = n;
                m.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(num1, 0, k);
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(Arrays.toString(intersect(num1, num2)));
    }
}

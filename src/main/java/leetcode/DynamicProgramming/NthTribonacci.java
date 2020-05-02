package main.java.leetcode.DynamicProgramming;

import java.util.ArrayList;

public class NthTribonacci {
    /**
     * https://leetcode.com/problems/n-th-tribonacci-number/
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        for(int i = 3; i <= n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3));
        }
        return list.get(n);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(200));
    }
}

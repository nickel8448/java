package main.java.leetcode.Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    private Queue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k + 1);
        this.k = k;
        for(int num : nums)
            add(num);
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() == k + 1)
            pq.remove();
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}

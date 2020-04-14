package main.java.leetcode.Array;

import java.util.*;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap =
            new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) {
            heap.add(stone);
        }

        // go through the heap
        while(heap.size() > 1) {
            int highestWeightStone = heap.poll();
            int secondHighWeightStone = heap.poll();
            if(highestWeightStone > secondHighWeightStone) {
                int newStone = highestWeightStone - secondHighWeightStone;
                heap.add(newStone);
            }
        }

        if(heap.size() == 0) return 0;
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(input));
    }
}

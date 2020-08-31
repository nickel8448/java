package main.java.leetcode.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestElements {
  public List<Integer> kSmallestElements(int[] elements, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
    for (int element : elements) {
      queue.add(element);
      if (queue.size() == k + 1) {
        queue.poll();
      }
    }
    List<Integer> result = new ArrayList<>(queue);
    return result;
  }

  public static void main(String[] args) {
    KSmallestElements k = new KSmallestElements();
    int[] elements = {9, 3, 7, -1, 5};
    System.out.println(k.kSmallestElements(elements, 2));
  }
}

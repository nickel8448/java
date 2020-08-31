package main.java.leetcode.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    if (!minHeap.isEmpty() && num < minHeap.peek()) {
      maxHeap.offer(num);
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }
    } else {
      minHeap.add(num);
      if (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.offer(minHeap.poll());
      }
    }
  }

  public double findMedian() {
    double median = 0;
    if (minHeap.size() < maxHeap.size()) {
      median = maxHeap.peek();
    } else if (minHeap.size() > maxHeap.size()) {
      median = minHeap.peek();
    } else {
      if (!minHeap.isEmpty() && !maxHeap.isEmpty())
        median = ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
    }
    return median;
  }

  public static void main(String[] args) {
    MedianFinder mf = new MedianFinder();
    mf.addNum(1);
    mf.addNum(2);
    System.out.println(mf.findMedian());
  }
}

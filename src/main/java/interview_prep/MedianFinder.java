package main.java.interview_prep;

import java.util.PriorityQueue;

/**
 * Question - https://leetcode.com/problems/find-median-from-data-stream/
 * Approach - Maintain two heaps and the max heap has more elements and that contains the median
 */

public class MedianFinder {
	PriorityQueue<Integer> maxHeap;  // Contains smaller elements. To hold the median
	PriorityQueue<Integer> minHeap;  // Contains larger elements
	/** initialize your data structure here **/
	public MedianFinder() {
		maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.peek());
		maxHeap.poll();
		if(maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.peek());
			minHeap.poll();
		}
	}

	public double findMedian() {
		return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : ((double) maxHeap.peek() + minHeap.peek()) * 0.5;
	}
}

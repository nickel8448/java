package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * <p>Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3 Output: [[1,2],[1,4],[1,6]] Explanation: The
 * first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * <p>Runtime: O(MN log(MN)) Status: Time limit exceeded
 */
public class FindKPairsWithSmallestSums {

  private class Node {
    int x;
    int y;
    int sum;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
      sum = x + y;
    }
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<Node> nodeList = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        nodeList.add(new Node(nums1[i], nums2[j]));
      }
    }

    // Priority queue to add the nodes
    PriorityQueue<Node> queue =
        new PriorityQueue<>(
            new Comparator<Node>() {
              @Override
              public int compare(Node n1, Node n2) {
                return Integer.compare(n1.sum, n2.sum);
              }
            });

    // Adding the nodes to the priority queue
    // This step and first step of adding nodes to the list could be merged in
    // one step
    for (int i = 0; i < nodeList.size(); i++) {
      queue.add(nodeList.get(i));
    }

    // Retrieving the nodes from the heap and adding them to the result
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (!queue.isEmpty()) {
        Node currentNode = queue.poll();
        int firstNum = currentNode.x;
        int secondNum = currentNode.y;
        List<Integer> listToAdd = new ArrayList<>();
        listToAdd.add(firstNum);
        listToAdd.add(secondNum);
        result.add(listToAdd);
      }
    }
    return result;
  }
}

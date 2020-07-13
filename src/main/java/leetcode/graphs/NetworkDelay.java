package main.java.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/** Status: Completed Complexity: O(V + E) Space Complexity: O(E log E) Time */
public class NetworkDelay {
  private class Node {
    int destination;
    int weight;

    public Node(int destination, int weight) {
      this.destination = destination;
      this.weight = weight;
    }
  }

  /**
   * @param times
   * @param N Number of nodes
   * @param K Starting node
   * @return times (i, j, k) i - source j - destination k - weight
   */
  public int networkDelayTime(int[][] times, int N, int K) {
    HashMap<Integer, LinkedList<Node>> graph = new HashMap<>();
    for (int i = 0; i < times.length; i++) {
      Node node = new Node(times[i][1], times[i][2]);
      graph.putIfAbsent(times[i][0], new LinkedList<>());
      graph.get(times[i][0]).add(node);
    }
    PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.weight - b.weight);
    HashMap<Integer, Integer> distance = new HashMap<>();
    int res = 0;
    pq.add(new Node(K, 0));
    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int node = current.destination;
      int dis = current.weight;
      if (distance.containsKey(node)) continue;
      distance.put(node, dis);
      res = Math.max(res, dis);
      if (graph.containsKey(node)) {
        for (Node n : graph.get(node)) {
          pq.add(new Node(n.destination, n.weight + dis));
        }
      }
    }
    return distance.size() == N ? res : -1;
  }

  public static void main(String[] args) {
    int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}, {3, 5, 2}, {3, 6, 3}};
    int[][] times2 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
    NetworkDelay n = new NetworkDelay();
    // System.out.println(n.networkDelayTime(times, 6, 2));
    System.out.println(n.networkDelayTime(times2, 3, 1));
  }
}

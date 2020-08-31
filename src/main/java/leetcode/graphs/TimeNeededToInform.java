package main.java.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/** https://leetcode.com/problems/time-needed-to-inform-all-employees/ */
public class TimeNeededToInform {
  private class Node {
    int id;
    int time;

    Node(int id, int time) {
      this.id = id;
      this.time = time;
    }
  }

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    HashMap<Integer, Set<Integer>> graph = new HashMap<>();
    // i -> subordinate
    // manager[i] -> manager
    for (int i = 0; i < n; i++) {
      graph.putIfAbsent(manager[i], new HashSet<>());
      graph.get(manager[i]).add(i);
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(-1, 0));
    int max = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Node current = queue.poll();
        max = Math.max(max, current.time);
        if (!graph.containsKey(current.id)) continue;
        for (int next : graph.get(current.id)) {
          queue.offer(new Node(next, current.time + informTime[next]));
        }
      }
    }
    return max;
  }
}

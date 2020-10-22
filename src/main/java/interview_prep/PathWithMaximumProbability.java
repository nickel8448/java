package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/path-with-maximum-probability/
 *
 * <p>Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000 Explanation: There are two paths from start to end, one having a probability of
 * success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 *
 * <p>Runtime:
 */
public class PathWithMaximumProbability {
  private class Node {
    int destination;
    double probability;

    Node(int destination, double probability) {
      this.destination = destination;
      this.probability = probability;
    }
  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    HashMap<Integer, LinkedList<Node>> graph = createGraph(edges, succProb);
    Set<Node> nodeSet = new HashSet<>();
    PriorityQueue<Node> queue =
        new PriorityQueue<>(
            new Comparator<Node>() {
              @Override
              public int compare(Node one, Node two) {
                return Double.compare(two.probability, one.probability);
              }
            });
    Node startNode = new Node(start, succProb[start]);
    queue.add(startNode);
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      if (currentNode.destination == end) return currentNode.probability;
      if (nodeSet.contains(currentNode)) continue;
      nodeSet.add(currentNode);
      double currentProbability = currentNode.probability;
      if (graph.containsKey(currentNode.destination)) {
        LinkedList<Node> neighbours = graph.get(currentNode.destination);
        for (Node neighbour : neighbours) {
          if (currentNode.destination == start) {
            queue.add(neighbour);
          } else {
            neighbour.probability *= currentProbability;
            queue.add(neighbour);
          }
        }
      }
    }
    return 0;
  }

  private HashMap<Integer, LinkedList<Node>> createGraph(int[][] edges, double[] succProb) {
    HashMap<Integer, LinkedList<Node>> graph = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int source = edges[i][0];
      int destination = edges[i][1];
      double probability = succProb[i];
      Node first = new Node(destination, probability);
      Node second = new Node(source, probability);
      LinkedList<Node> firstNei = graph.getOrDefault(source, new LinkedList<Node>());
      firstNei.add(first);
      graph.put(source, firstNei);
      LinkedList<Node> secondNei = graph.getOrDefault(destination, new LinkedList<Node>());
      secondNei.add(second);
      graph.put(destination, secondNei);
    }
    return graph;
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *
 * <p>Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]] Output: 2
 *
 * <p>Approach: DFS
 *
 * <p>Runtime: O(V + E)
 */
public class NumberOfConnectedComponents {
  public int countComponents(int n, int[][] edges) {
    if (n <= 1) return n;
    boolean[] visited = new boolean[n];
    HashMap<Integer, LinkedList<Integer>> graph = createGraphFromEdges(edges);

    int numComponents = 0;
    for (int node = 0; node < n; node++) {
      if (!visited[node]) {
        dfs(graph, node, visited);
        numComponents++;
      }
    }
    return numComponents;
  }

  private void dfs(HashMap<Integer, LinkedList<Integer>> graph, int node, boolean[] visited) {
    visited[node] = true;
    if (graph.containsKey(node)) {
      for (int edge : graph.get(node)) {
        if (!visited[edge]) dfs(graph, edge, visited);
      }
    }
  }

  private HashMap<Integer, LinkedList<Integer>> createGraphFromEdges(int[][] edges) {
    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      LinkedList edgeList = graph.getOrDefault(edge[0], new LinkedList<>());
      edgeList.add(edge[1]);

      LinkedList secondEdgeList = graph.getOrDefault(edge[1], new LinkedList<>());
      secondEdgeList.add(edge[0]);

      graph.put(edge[0], edgeList);
      graph.put(edge[1], secondEdgeList);
    }
    return graph;
  }
}

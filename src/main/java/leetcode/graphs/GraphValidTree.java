package main.java.leetcode.graphs;

import java.util.*;

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    HashMap<Integer, LinkedList<Integer>> graph = getMap(edges);
    HashMap<Integer, Boolean> visitedMap = new HashMap<>();
    if (dfs(graph, 0, visitedMap, -1)) {
      return false;
    }
    return true;
  }

  /**
   * Returns if there is a cycle
   *
   * @param graph
   * @param node
   * @param visitedMap
   * @return
   */
  private boolean dfs(
      HashMap<Integer, LinkedList<Integer>> graph,
      int node,
      HashMap<Integer, Boolean> visitedMap,
      int parent) {
    visitedMap.put(node, true);
    if (graph.containsKey(node)) {
      for (Integer child : graph.get(node)) {
        // If the adjacent node has not been visited, visit the node
        if (!visitedMap.containsKey(child)) {
          if (dfs(graph, child, visitedMap, node)) return true;
        }
        // adjacent node has been visited and if it is not the parent that means
        // there is a cycle
        else if (visitedMap.containsKey(child) && child != parent) {
          return true;
        }
      }
    }
    return false;
  }

  private HashMap<Integer, LinkedList<Integer>> getMap(int[][] edges) {
    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int parent = edge[0];
      int child = edge[1];
      LinkedList<Integer> parentList = graph.getOrDefault(parent, new LinkedList<>());
      LinkedList<Integer> childList = graph.getOrDefault(child, new LinkedList<>());
      parentList.add(child);
      childList.add(parent);
      graph.put(parent, parentList);
      graph.put(child, childList);
    }
    return graph;
  }
}

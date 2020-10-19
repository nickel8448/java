package main.java.interview_prep;

import java.util.*;

/**
 * Problem:
 *
 * <p>Approach: 1) Detect a cycle 2) Check if you reach the destination
 *
 * <p>Runtime:
 */
public class LeadToDestination {
  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    HashMap<Integer, LinkedList<Integer>> graph = constructGraph(edges, n);
    Set<Integer> visited = new HashSet<>();
    Set<Integer> currentPath = new HashSet<>();
    return DFS(graph, visited, currentPath, source, destination);
  }

  private boolean DFS(
      HashMap<Integer, LinkedList<Integer>> graph,
      Set<Integer> visited,
      Set<Integer> currentPath,
      int source,
      int destination) {
    if (currentPath.contains(source)) return false; // there is a cycle
    // this has no outgoing edges and should be the destination
    if (graph.get(source).size() == 0) return source == destination;
    currentPath.add(source);
    LinkedList<Integer> adjNodes = graph.get(source);
    for (int node : adjNodes) {
      if (!visited.contains(node)) {
        if (!DFS(graph, visited, currentPath, node, destination)) {
          return false;
        }
      }
    }
    visited.add(source);
    currentPath.remove(source);
    return true;
  }

  private HashMap<Integer, LinkedList<Integer>> constructGraph(int[][] edges, int n) {
    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new LinkedList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int source = edges[i][0];
      int destination = edges[i][1];
      graph.get(source).add(destination);
    }
    return graph;
  }
}

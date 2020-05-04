package main.java.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllPaths {
  /**
   * Problem: https://leetcode.com/problems/all-paths-from-source-to-target/ 2/5/2020
   *
   * @param graph
   * @return
   */
  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    HashMap<Integer, ArrayList<Integer>> edgesMap = new HashMap<>();
    addEdgesToMap(graph, edgesMap);
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> nodesList = new ArrayList<>();
    nodesList.add(0);
    dfs(edgesMap, graph.length - 1, 0, nodesList, result);
    return result;
  }

  private static void dfs(
      HashMap<Integer, ArrayList<Integer>> edgesMap,
      int destination,
      int currentNode,
      ArrayList<Integer> nodes,
      List<List<Integer>> result) {
    if (destination == currentNode) {
      result.add(new ArrayList<Integer>(nodes));
    } else {
      ArrayList<Integer> adjacentNodes = edgesMap.get(currentNode);
      for (int node : adjacentNodes) {
        nodes.add(node);
        dfs(edgesMap, destination, node, nodes, result);
        nodes.remove(nodes.size() - 1);
      }
    }
  }

  private static void addEdgesToMap(int[][] graph, HashMap<Integer, ArrayList<Integer>> edgesMap) {
    for (int i = 0; i < graph.length; i++) {
      edgesMap.put(i, new ArrayList<Integer>());
      for (int j = 0; j < graph[i].length; j++) {
        edgesMap.get(i).add(graph[i][j]);
      }
    }
  }

  public static void main(String[] args) {
    int[][] graph = {
      {1, 2},
      {3},
      {3},
      {},
    };
    System.out.println(allPathsSourceTarget(graph));
  }
}

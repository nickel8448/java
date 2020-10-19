package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/evaluate-division/ a/b = 2 b/c = 3 Approach: Backtracking
 * Runtime: O(M*N)
 */
public class EvaluateDivision {

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    HashMap<String, HashMap<String, Double>> graph = generateGraph(equations, values);
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String numerator = queries.get(i).get(0);
      String denominator = queries.get(i).get(1);
      if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
        result[i] = -1.0;
      } else if (numerator.equals(denominator)) {
        result[i] = 1.0;
      } else {
        Set<String> visited = new HashSet<>();
        result[i] = DFS(graph, numerator, denominator, visited, 1.0);
      }
    }
    return result;
  }

  private double DFS(
      HashMap<String, HashMap<String, Double>> graph,
      String source,
      String destination,
      Set<String> visited,
      double ans) {
    visited.add(source);
    double ret = -1.0;
    HashMap<String, Double> neighbours = graph.get(source);
    if (neighbours.containsKey(destination)) {
      ret = ans * neighbours.get(destination);
    } else {
      for (String neighbour : neighbours.keySet()) {
          if (!visited.contains(neighbour)) {
          ret = DFS(graph, neighbour, destination, visited, ans * neighbours.get(neighbour));
          if (ret != -1.0) break;
          visited.remove(source);
        }
      }
    }
    return ret;
  }

  private HashMap<String, HashMap<String, Double>> generateGraph(
      List<List<String>> equations, double[] values) {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String numerator = equations.get(i).get(0);
      String denominator = equations.get(i).get(1);
      double weight = values[i];
      if (!graph.containsKey(numerator)) {
        graph.put(numerator, new HashMap<String, Double>());
      }
      graph.get(numerator).put(denominator, weight);
      if (!graph.containsKey(denominator)) {
        graph.put(denominator, new HashMap<String, Double>());
      }
      graph.get(denominator).put(numerator, 1.0 / weight);
    }
    return graph;
  }
}

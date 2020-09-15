package main.java.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;

// 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
// [[1,0],[2,0],[3,1],[3,2]]
//
// Problem: https://leetcode.com/problems/course-schedule-ii/

public class CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
    // node -> incoming degree map
    int[] indegreeArray = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int parent = prerequisites[i][1];
      int child = prerequisites[i][0];
      if (!graph.containsKey(parent)) {
        graph.put(parent, new LinkedList<>());
      }
      graph.get(parent).add(child);
      indegreeArray[child]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegreeArray.length; i++) {
      if (indegreeArray[i] == 0) {
        queue.offer(i);
      }
    }
    int count = 0;
    int[] result = new int[numCourses];
    while (!queue.isEmpty()) {
      int current = queue.poll();
      --numCourses;
      result[count] = current;
      LinkedList<Integer> children = graph.get(current);
      if (children == null) continue;
      for (int child : children) {
        indegreeArray[child]--;
        if (indegreeArray[child] == 0) {
          queue.offer(child);
        }
      }
      count++;
    }
    if (numCourses == 0) return result;
    else return new int[] {};
  }
}

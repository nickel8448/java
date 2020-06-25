package main.java.leetcode.graphs;

import java.util.*;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      int parent = prerequisite[1];
      int child = prerequisite[0];
      LinkedList<Integer> list = adjList.getOrDefault(parent, new LinkedList<>());
      list.add(child);
      adjList.put(parent, list);
      indegree[prerequisite[0]]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    LinkedList<Integer> result = new LinkedList<>();
    int count = 0;
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int currentCourse = queue.poll();
      if (indegree[currentCourse] == 0) {
        count++;
        result.add(currentCourse);
      }
      if (!adjList.containsKey(currentCourse)) continue;
      for (int child : adjList.get(currentCourse)) {
        indegree[child]--;
        if (indegree[child] == 0) {
          queue.add(child);
        }
      }
    }
    return count == numCourses;
  }
}

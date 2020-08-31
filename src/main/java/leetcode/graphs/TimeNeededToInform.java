package main.java.leetcode.graphs;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the
 * company has is the one with headID.
 *
 * <p>Each employee has one direct manager given in the manager array where manager[i] is the direct
 * manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination
 * relationships have a tree structure.
 *
 * <p>The head of the company wants to inform all the employees of the company of an urgent piece of
 * news. He will inform his direct subordinates and they will inform their subordinates and so on
 * until all employees know about the urgent news.
 *
 * <p>The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e
 * After informTime[i] minutes, all his direct subordinates can start spreading the news).
 *
 * <p>Return the number of minutes needed to inform all the employees about the urgent news.
 */
import java.util.HashMap;
import java.util.LinkedList;

public class TimeNeededToInform {
  private class Node {
    int manager;
    int id;
    int informTime;

    Node(int manager, int id, int informTime) {
      this.manager = manager;
      this.id = id;
      this.informTime = informTime;
    }
  }

  private int numNodesVisited = 0;
  private int time = Integer.MIN_VALUE;

  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    // 1. Create a HashMap of manager to subordinates
    // manager[i] - manager
    // i - subordinate
    HashMap<Integer, LinkedList<Node>> adjacentMap = generateAdjacacenyMap(manager, informTime);
    // boolean[] visited = new boolean[manager.length];
    dfs(adjacentMap, n, headID, 0, informTime);
    return time;
  }

  private void dfs(
      HashMap<Integer, LinkedList<Node>> adjacentMap, int n, int manager, int runningTime, int[] informTime) {
    LinkedList<Node> subordinates = adjacentMap.get(manager);
    if(subordinates != null) {
        for (Node subordinate : subordinates) {
            dfs(adjacentMap, n, subordinate.id, runningTime + subordinate.informTime, informTime);
            if (runningTime > time) {
                time = runningTime;
            }
        }
    } else {
        if (runningTime + informTime[manager] > time) {
            time = runningTime;
        }
    }
  }

  private HashMap<Integer, LinkedList<Node>> generateAdjacacenyMap(
      int[] manager, int[] informTime) {
    HashMap<Integer, LinkedList<Node>> adjacentMap = new HashMap<>();
    for (int i = 0; i < manager.length; i++) {
      if (manager[i] != -1) {
        if (!adjacentMap.containsKey(manager[i])) {
          adjacentMap.put(manager[i], new LinkedList<Node>());
        }
        adjacentMap.get(manager[i]).add(new Node(manager[i], i, informTime[i]));
      }
    }
    return adjacentMap;
  }

    public static void main(String[] args) {
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        TimeNeededToInform t = new TimeNeededToInform();
        t.numOfMinutes(15, 0, manager, informTime);
    }
}

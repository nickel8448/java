package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * <p><Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * <p>Output: 7
 *
 * <p>Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2), the point
 * (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is
 * minimal. So return 7.
 *
 * <p>Approach: Start by looping through the Matrix and getting all the nodes with 0 1) Start BFS if
 * a 0 is found Adding a sentinel node so that I know that one part of BFS has finished 2) Each
 * level of BFS will be a plus one 3) The new value will be added and if the value is not inifite,
 * take the lesser of the current and the new value
 *
 * <p>Complexity - O(mn)
 */
public class ShortestDistanceFromAllBuildings {
}

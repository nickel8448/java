package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 *
 * <p>Input: MyCalendar(); MyCalendar.book(10, 20); // returns true MyCalendar.book(15, 25); //
 * returns false MyCalendar.book(20, 30); // returns true Explanation: The first event can be
 * booked. The second can't because time 15 is already booked by another event. The third event can
 * be booked, as the first event takes every time less than 20, but not including 20.
 *
 * <p>Runtime: Addition of a new event - O(nLogn)
 */

public class ShortestPathInAGridWithObstacles {
  int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][][] visited = new boolean[n][m][k+1];  // creating a visited array with n * m and k + 1 dimensions
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==n-1 && c==m-1){
                    // if the code reaches the end get the result
                    return res;
                }
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){  // Checking if the nextR and nextC is valid
                        if(grid[nextR][nextC]==1){  // If there is an obstacle
                            nextK++;  // increase the number of obstacles seen
                        }
                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
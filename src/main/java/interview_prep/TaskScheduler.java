package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/task-scheduler/
 *
 * <p>Input: tasks = ["A","A","A","B","B","B"], n = 2 Output: 8 Explanation: A -> B -> idle -> A ->
 * B -> idle -> A -> B There is at least 2 units of time between any two same tasks.
 *
 * <p>Approach: Brute Force using Stack and HashMap 1) Add the first element to result - mark it as
 * used 2) Add the element to HashMap with value n 3) Add the value to the stack if n > 0 4) Find a
 * value which is not in the HashMap 5) Found B and add it to the HashMap with n and reduce the
 * value of the char on top of the stack 6) Find the next value in the char[] which is not in the
 * Map 6.1) If not found, it is idle time and redeuce the value of all keys by 1
 *
 * <p>Runtime:
 */
public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    int[] frequency = new int[26];
    for (char c : tasks) {
      frequency[c - 'A']++;
    }
    Arrays.sort(frequency);
    int maxFrequency = frequency[25];
    int idleTime = (maxFrequency - 1) * n;

    for (int i = 24; i >= 0; i--) {
      idleTime -= Math.min(frequency[i], maxFrequency - 1);
    }
    return idleTime > 0 ? idleTime + tasks.length : tasks.length;
  }
}

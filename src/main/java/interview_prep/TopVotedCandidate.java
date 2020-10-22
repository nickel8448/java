package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/online-election/
 *
 * <p>If this becomes streaming then the treemap modification will be difficult
 */
public class TopVotedCandidate {
  TreeMap<Integer, Integer> timeMap = new TreeMap<>();

  public TopVotedCandidate(int[] persons, int[] times) {
    int[] count = new int[persons.length];
    int maxCount = 0;
    for (int i = 0; i < persons.length; i++) {
      int person = persons[i];
      int time = times[i];
      count[person]++;
      if (count[person] >= maxCount) {
        maxCount = count[person];
        timeMap.put(time, person);
      }
    }
  }

  public int q(int t) {
    return timeMap.get(timeMap.floorKey(t));
  }
}

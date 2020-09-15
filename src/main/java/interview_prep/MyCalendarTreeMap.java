package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/my-calendar-i/
 *
 * <p>Input: MyCalendar(); MyCalendar.book(10, 20); // returns true MyCalendar.book(15, 25); //
 * returns false MyCalendar.book(20, 30); // returns true Explanation: The first event can be
 * booked. The second can't because time 15 is already booked by another event. The third event can
 * be booked, as the first event takes every time less than 20, but not including 20.
 *
 * <p>Runtime: Addition of a new event - O(nLogn)
 */
public class MyCalendarTreeMap {
  TreeMap<Integer, Integer> calendar;

  MyCalendarTreeMap() {
    calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer prevEnd = calendar.floorKey(start);
    Integer nextStart = calendar.ceilingKey(start);
    if ((prevEnd == null || calendar.get(prevEnd) <= start)
        && (nextStart == null || end <= nextStart)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }
}

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
public class MyCalendar {

  private class Event implements Comparable<Event> {
    int start;
    int end;

    Event(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Event otherEvent) {
      return Integer.compare(this.start, otherEvent.start);
    }
  }

  List<Event> eventList;

  public MyCalendar() {
    eventList = new LinkedList<>();
  }

  public boolean book(int start, int end) {
    Event newEvent = new Event(start, end);
    eventList.add(newEvent); // TODO: Disallow this booking later, if it is not working
    Collections.sort(eventList);
    Event prevEvent = eventList.get(0);
    for (int i = 1; i < eventList.size(); i++) {
      Event currentEvent = eventList.get(i);
      if (currentEvent.start < prevEvent.end) {
        eventList.remove(newEvent);
        return false;
      }
      prevEvent = currentEvent;
    }
    return true;
  }
}

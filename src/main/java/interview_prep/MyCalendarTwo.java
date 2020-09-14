package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * <p>MyCalendar(); MyCalendar.book(10, 20); // returns true MyCalendar.book(50, 60); // returns
 * true MyCalendar.book(10, 40); // returns true MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true MyCalendar.book(25, 55); // returns true Explanation: The
 * first two events can be booked. The third event can be double booked. The fourth event (5, 15)
 * can't be booked, because it would result in a triple booking. The fifth event (5, 10) can be
 * booked, as it does not use time 10 which is already double booked. The sixth event (25, 55) can
 * be booked, as the time in [25, 40) will be double booked with the third event; the time [40, 50)
 * will be single booked, and the time [50, 55) will be double booked with the second event.
 *
 * <p>Approach:
 *
 * <p>Runtime:
 */
public class MyCalendarTwo {
  List<int[]> calendar;
  List<int[]> overlaps;

  public MyCalendarTwo() {
    overlaps = new LinkedList<>(); // intersections
    calendar = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    for (int[] iv : overlaps) {
      // If the new event collides with an intersection then it is triple booked
      if (iv[1] > start && end > iv[0]) return false;
    }
    for (int[] iv : calendar) {
      if (iv[1] > start && end > iv[0]) {
        // Only storing the intersections and NOT the complete events
        overlaps.add(new int[] {Math.max(start, iv[0]), Math.min(end, iv[1])});
      }
    }
    calendar.add(new int[] {start, end});
    return true;
  }
}

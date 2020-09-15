package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/my-calendar-iii/
 *
 * <p>MyCalendarThree(); MyCalendarThree.book(10, 20); // returns 1 MyCalendarThree.book(50, 60); //
 * returns 1 MyCalendarThree.book(10, 40); // returns 2 MyCalendarThree.book(5, 15); // returns 3
 * MyCalendarThree.book(5, 10); // returns 3 MyCalendarThree.book(25, 55); // returns 3 Explanation:
 * The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking. The
 * third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking. The
 * remaining events cause the maximum K-booking to be only a 3-booking. Note that the last event
 * locally causes a 2-booking, but the answer is still 3 because eg. [10, 20), [10, 40), and [5, 15)
 * are still triple booked.
 *
 * <p>Status: Pending
 */
public class MyCalendarIII {
  HashMap<List<Integer>, Integer> intersectionMap;
  List<List<Integer>> intersectionList;
  List<List<Integer>> eventList;

  public MyCalendarIII() {
    intersectionMap = new HashMap<>();
    intersectionList = new ArrayList<>();
    eventList = new ArrayList<>();
  }

  public int book(int start, int end) {
    for (List<Integer> intersection : eventList) {
      if (intersection.get(1) > start && end > intersection.get(0)) {
        List<Integer> intersectionToAdd = new ArrayList<>();
        intersectionToAdd.add(Math.max(start, intersection.get(0)));
        intersectionToAdd.add(Math.min(end, intersection.get(1)));
        intersectionMap.put(intersectionToAdd, 0); // What is there are multiple same intersections
        if (!intersectionList.contains(intersectionToAdd)) intersectionList.add(intersectionToAdd);
      }
    }
    eventList.add(new ArrayList<>(Arrays.asList(start, end)));

    int[] event = new int[] {start, end};
    int intersections = 1;
    for (List<Integer> intersection : intersectionList) {
      if (event[1] > intersection.get(0) && intersection.get(1) > event[0]) {
        intersectionMap.put(intersection, intersectionMap.get(intersection) + 1);
        intersections += intersectionMap.get(intersection);
      }
    }
    return intersections;
  }

  public static void main(String[] args) {
    MyCalendarIII c = new MyCalendarIII();
    c.book(10, 20);
    c.book(50, 60);
    c.book(10, 40);
    c.book(5, 15);
    c.book(5, 10);
    c.book(25, 55);
  }
}

package main.java.leetcode.PriorityQueue;

import java.util.PriorityQueue;

public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<Integer> startQueue = new PriorityQueue<>();
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++) {
            startQueue.add(intervals[i][0]);
            endQueue.add(intervals[i][1]);
        }
        startQueue.poll();
        while(startQueue.size() != 0) {
            if(endQueue.peek() != null) {
                if(startQueue.poll() < endQueue.poll())
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {0, 30},
            {5, 10}
        };
        System.out.println(canAttendMeetings(intervals));
    }
}

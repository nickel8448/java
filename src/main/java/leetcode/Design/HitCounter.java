package main.java.leetcode.Design;

import java.util.HashMap;
import java.util.PriorityQueue;

/** https://leetcode.com/problems/design-hit-counter/ */
public class HitCounter {

  private final int TIME_WINDOW = 300;

  private HashMap<Integer, Integer> hitMap;
  // Priority queue is not required because the timestamps will come in a chronological order
  // hence a linkedlist could be fine too
  private PriorityQueue<Integer> pq;

  /*
   * Constructor
   */
  public HitCounter() {
    hitMap = new HashMap<>();
    pq = new PriorityQueue<>();
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
      if(pq.size() != 0 && (timestamp - TIME_WINDOW) >= pq.peek()) {
          removeTimeStamps(pq, timestamp);
      }
      pq.add(timestamp);
      hitMap.put(timestamp, hitMap.getOrDefault(timestamp, 0) + 1);

  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
      removeTimeStamps(pq, timestamp);
      int totalHits = 0;
      for(Integer key : hitMap.keySet()) {
          totalHits += hitMap.get(key);
      }
      return totalHits;
  }

  private void removeTimeStamps(PriorityQueue<Integer> pq, int timestamp) {
      while(pq.size() != 0 && (timestamp - TIME_WINDOW) >= pq.peek())
          hitMap.remove(pq.poll());
  }

//    public static void main(String[] args) {
//        HitCounter h = new HitCounter();
//        h.hit(1);
//        h.hit(1);
//        h.hit(1);
//        h.hit(300);
//        System.out.println(h.getHits(300));
//        h.hit(300);
//        System.out.println(h.getHits(300));
//        h.hit(301);
//        System.out.println(h.getHits(301));
//    }
}

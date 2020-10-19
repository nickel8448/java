package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/logger-rate-limiter/
 *
 * <p>Input: cardPoints = [1,2,3,4,5,6,1], k = 3 Output: 12 Explanation: After the first step, your
 * score will always be 1. However, choosing the rightmost card first will maximize your total
 * score. The optimal strategy is to take the three cards on the right, giving a final score of 1 +
 * 6 + 5 = 12.
 *
 * <p>[100, 40, 17, 9, 73, 75] k = 3
 *
 * <p>Approach: Sliding window
 *
 * <p>Complexity - O(n)
 */
class Logger {
  HashMap<String, Integer> logger;
  /** Initialize your data structure here. */
  public Logger() {
    logger = new HashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed. The timestamp is in seconds
   * granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (logger.containsKey(message)) {
      if (timestamp - logger.get(message) >= 10) {
        logger.put(message, timestamp);
        return true;
      } else {
        return false;
      }
    } else {
      logger.put(message, timestamp);
      return true;
    }
  }
}

package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/hand-of-straights/
 *
 * <p>Input: hand = [1,2,3,6,2,3,4,7,8], W = 3 Output: true Explanation: Alice's hand can be
 * rearranged as [1,2,3],[2,3,4],[6,7,8].:
 *
 * <p>Approach: Sort the array too 1) Create a fequency map of each number in the array 2) Create a
 * map which has required numbers and pending in number left in this list 3) Loop through each
 * number in hand 4) Deduct the fequency of the number from the frequency map 5) Add n[i] + 1 to the
 * required number map 6) in the end frequency and required map size should be 0
 *
 * <p>Complexity - O(mn)
 */
public class HandOfStraights {
  public boolean isNStraightHand(int[] hand, int W) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : hand) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }
    Arrays.sort(hand);
    for (int num : hand) {
      if (frequencyMap.get(num) >= 1) {
        for (int j = 0; j < W; j++) {
          int currentElement = num + j;
          if (frequencyMap.containsKey(currentElement)) {
            if (frequencyMap.get(currentElement) <= 0) {
              return false;
            } else {
              frequencyMap.put(currentElement, frequencyMap.get(currentElement) - 1);
            }
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    HandOfStraights h = new HandOfStraights();
    System.out.println(h.isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
  }
}

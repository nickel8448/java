package main.java.leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class HandOfStraights {
  public boolean isNStraightHand(int[] hand, int W) {
    if (hand.length % W != 0) return false;
    // nextMap = required next number -> list of Numbers
    HashMap<Integer, ArrayList<Integer>> nextMap = new HashMap<>();
    for (int i = 0; i < hand.length; i++) {
      int currentNum = hand[i];
      if (nextMap.containsKey(currentNum)) {
        if (nextMap.get(currentNum).size() == W - 1) {
          nextMap.remove(currentNum);
        } else {
          ArrayList<Integer> currentNumList = nextMap.get(currentNum);
          currentNumList.add(currentNum);
          nextMap.put(currentNum + 1, currentNumList);
          nextMap.remove(currentNum);
        }
      } else {
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(currentNum);
        nextMap.put(currentNum + 1, numList);
      }
    }
    return nextMap.size() == 0;
  }
}

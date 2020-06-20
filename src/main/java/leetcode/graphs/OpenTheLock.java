package main.java.leetcode.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class OpenTheLock {
    /**
     * https://leetcode.com/problems/open-the-lock/
     * Status: Completed
     * Complexity: There are 10 x 10 x 10 x 10 possible combinations => 10 ^ 4
     * => A^N (A is the number of digits in our alphabet)
     * N^2 because of the number of branches I am creating at each level
     * D for the construction of dead ends
     * Final complexity: (N^2 * A^n + D)
     * @param deadends
     * @param target
     * @return
     */
  public static int openLock(String[] deadends, String target) {
    String start = "0000";
    HashSet<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
    HashMap<String, Integer> codeLevel = new HashMap<>();
    LinkedList<String> queue = new LinkedList<>();
    queue.addLast(start);
    codeLevel.put(start, 0);
    while (!queue.isEmpty()) {
      String currentPin = queue.pop();
      if (!deadendsSet.contains(currentPin)) {
        LinkedList<String> next = generateNextStrings(currentPin);
        for (String nextPin : next) {
          if (codeLevel.containsKey(nextPin)) {
            int newLevel = codeLevel.get(currentPin) + 1;
            codeLevel.put(nextPin, Math.min(newLevel, codeLevel.get(nextPin)));
          } else {
            codeLevel.put(nextPin, codeLevel.get(currentPin) + 1);
            queue.add(nextPin);
          }
          if (nextPin.equals(target)) {
            return codeLevel.get(nextPin);
          }
        }
      }
    }
    return -1;
  }

  private static LinkedList<String> generateNextStrings(String start) {
    LinkedList<String> nextString = new LinkedList<>();
    for (int i = 0; i < 4; i++) {
      StringBuilder addBuilder = new StringBuilder(start);
      char currentChar = addBuilder.charAt(i);
      int currentCharInt = currentChar - '0';
      addBuilder.setCharAt(i, Character.forDigit(currentCharInt + 1, 10));
      StringBuilder subBuilder = new StringBuilder(start);
      currentChar = subBuilder.charAt(i);
      if (currentChar == '0') {
        currentCharInt = 9;
      } else {
        currentCharInt -= 1;
      }
      subBuilder.setCharAt(i, Character.forDigit(currentCharInt, 10));
      nextString.add(addBuilder.toString());
      nextString.add(subBuilder.toString());
    }
    return nextString;
  }

  public static void main(String[] args) {
    System.out.println(openLock(new String[] {"1100"}, "8899"));
  }
}

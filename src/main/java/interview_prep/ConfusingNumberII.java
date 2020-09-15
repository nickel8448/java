package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/confusing-number-ii/
 *
 * <p>Input: Input: 20 Output: 6 Explanation: The confusing numbers are [6,9,10,16,18,19]. 6
 * converts to 9. 9 converts to 6. 10 converts to 01 which is just 1. 16 converts to 91. 18 converts
 * to 81. 19 converts to 61.
 *
 * <p>Runtime: O(2 * M * N) Status: Time limit exceeded
 */
public class ConfusingNumberII {
  public int confusingNumberII(int N) {
    HashMap<Integer, Integer> confusingNumbers = getConfusingNumberMap();
    Set<Integer> invalidNumber = new HashSet<>(Arrays.asList(2, 3, 4, 5, 7));
    Set<Integer> confusingNumberSet = new HashSet<>();
    int numConfusing = 0;
    for (int i = 0; i <= N; i++) {
      String numberString = Integer.toString(i);
      StringBuilder reverseString = new StringBuilder();
      for (int j = numberString.length() - 1; j >= 0; j--) {
        char c = numberString.charAt(j);
        int charNum = Character.getNumericValue(c);
        if (confusingNumbers.containsKey(charNum)) {
          reverseString.append(confusingNumbers.get(charNum));
        } else if (invalidNumber.contains(charNum)) {
          reverseString = new StringBuilder();
          break;
        }
      }
      if (reverseString.length() != 0) {
        int newConfusingNum = Integer.parseInt(reverseString.toString());
        if (i != newConfusingNum) {
          confusingNumberSet.add(i);
          numConfusing++;
        }
      }
    }
    List<Integer> sorted = new ArrayList<>(confusingNumberSet);
    Collections.sort(sorted);
    return numConfusing;
  }

  private HashMap<Integer, Integer> getConfusingNumberMap() {
    HashMap<Integer, Integer> confusingNumberMap = new HashMap<>();
    confusingNumberMap.put(0, 0);
    confusingNumberMap.put(1, 1);
    confusingNumberMap.put(6, 9);
    confusingNumberMap.put(8, 8);
    confusingNumberMap.put(9, 6);
    return confusingNumberMap;
  }

  public static void main(String[] args) {
    ConfusingNumberII c = new ConfusingNumberII();
    System.out.println(c.confusingNumberII(100));
  }
}

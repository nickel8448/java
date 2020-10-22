package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/gas-station/
 *
 * <p>Input: gas = [1,2,3,4,5] cost = [3,4,5,1,2]
 *
 * <p>Output: 3
 *
 * <p>Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 =
 * 4 Travel to station 4. Your tank = 4 - 1 + 5 = 8 Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6 Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 */
public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int sum = 0;
    int start = 0;
    int deficit = 0;
    for (int i = 0; i < gas.length; i++) {
      sum = sum + (gas[i] - cost[i]);
      if (sum < 0) {
        start = i + 1;
        deficit += sum;
        sum = 0;
      }
    }
    return sum + deficit == 0 ? start : -1;
  }
}

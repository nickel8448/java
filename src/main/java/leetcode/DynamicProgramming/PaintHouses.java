package main.java.leetcode.DynamicProgramming;

import java.util.HashMap;

public class PaintHouses {

  private HashMap<String, Integer> memo;

  /**
   * One of the first dynamic programming problems Problem:
   * https://leetcode.com/problems/paint-house/solution/
   *
   * @param costs
   * @return
   */
  public int minCost(int[][] costs) {
    if (costs.length == 0) return 0;
    memo = new HashMap<>();
    int totalStartingRedCost = minCostHelperDP(costs, 0, 0);
    int totalStartingGreenCost = minCostHelperDP(costs, 1, 0);
    int totalStartingBlueCost = minCostHelperDP(costs, 2, 0);
    return Math.min(totalStartingRedCost, Math.min(totalStartingGreenCost, totalStartingBlueCost));
  }

  /**
   * Dynamic Programming approach. In this approach we start bottom up. We store the minimum costs
   * starting from the bottom and find the min in the list in the end
   *
   * @param costs
   * @return
   */
  public int minCostDP(int[][] costs) {
    if (costs.length == 0) return 0;
    // loop running until all the houses are covered
    int[] previousRow = costs[costs.length - 1];
    for (int i = costs.length - 2; i >= 0; i--) {
      int[] currentRow = costs[i].clone();
      currentRow[0] += Math.min(previousRow[1], previousRow[2]);
      currentRow[1] += Math.min(previousRow[0], previousRow[2]);
      currentRow[2] += Math.min(previousRow[0], previousRow[1]);
      previousRow = currentRow;
    }
    return Math.min(previousRow[0], Math.min(previousRow[1], previousRow[2]));
  }

  /**
   * Recursive tree brute force approach. This is a tree approach where at the end of the tree the
   * code decides to chooses the minimum of the value amongst two houses and continues
   *
   * @param costs
   * @param colourIndex
   * @param houseIndex
   * @return
   */
  private int minCostHelperDP(int[][] costs, int colourIndex, int houseIndex) {
    if (memo.containsKey(getKey(houseIndex, colourIndex)))
      return memo.get(getKey(houseIndex, colourIndex));
    int totalCost = costs[houseIndex][colourIndex];
    if (houseIndex == costs.length - 1) {
      return totalCost;
    } else if (colourIndex == 0) {
      int greenHouseCost = minCostHelperDP(costs, 1, houseIndex + 1);
      int blueHouseCost = minCostHelperDP(costs, 2, houseIndex + 1);
      totalCost += Math.min(greenHouseCost, blueHouseCost);
    } else if (colourIndex == 1) {
      int redHouseCost = minCostHelperDP(costs, 0, houseIndex + 1);
      int blueHouseCost = minCostHelperDP(costs, 2, houseIndex + 1);
      totalCost += Math.min(redHouseCost, blueHouseCost);
    } else if (colourIndex == 2) {
      int redHouseCost = minCostHelperDP(costs, 0, houseIndex + 1);
      int greenHouseCost = minCostHelperDP(costs, 1, houseIndex + 1);
      totalCost += Math.min(redHouseCost, greenHouseCost);
    }
    memo.put(getKey(houseIndex, colourIndex), totalCost);
    return totalCost;
  }

  /**
   * Recursive tree brute force approach. This is a tree approach where at the end of the tree the
   * code decides to chooses the minimum of the value amongst two houses and continues. This
   * function computes each branch of the tree and does not store the result which means it does not
   * use Dynamic Programming
   *
   * @param costs
   * @param colourIndex
   * @param houseIndex
   * @return
   */
  private int minCostHelper(int[][] costs, int colourIndex, int houseIndex) {
    int totalCost = costs[houseIndex][colourIndex];
    if (houseIndex == costs.length - 1) {
      return totalCost;
    } else if (colourIndex == 0) {
      int greenHouseCost = minCostHelper(costs, 1, houseIndex + 1);
      int blueHouseCost = minCostHelper(costs, 2, houseIndex + 1);
      totalCost += Math.min(greenHouseCost, blueHouseCost);
    } else if (colourIndex == 1) {
      int redHouseCost = minCostHelper(costs, 0, houseIndex + 1);
      int blueHouseCost = minCostHelper(costs, 2, houseIndex + 1);
      totalCost += Math.min(redHouseCost, blueHouseCost);
    } else if (colourIndex == 2) {
      int redHouseCost = minCostHelper(costs, 0, houseIndex + 1);
      int greenHouseCost = minCostHelper(costs, 1, houseIndex + 1);
      totalCost += Math.min(redHouseCost, greenHouseCost);
    }
    return totalCost;
  }

  /**
   * Returns the house index and colour index in the form of a key
   *
   * @param houseIndex
   * @param colourIndex
   * @return
   */
  private static String getKey(int houseIndex, int colourIndex) {
    return houseIndex + " - " + colourIndex;
  }

  public static void main(String[] args) {
    int[][] input = {
      {2, 18, 1},
      {17, 19, 14},
      {5, 11, 3},
      {9, 8, 12},
      {19, 11, 6},
      {11, 12, 10},
      {3, 18, 10},
      {10, 15, 17},
      {9, 2, 5},
      {11, 12, 1},
      {1, 15, 11},
      {18, 9, 15},
      {8, 8, 12},
      {6, 12, 6},
      {1, 11, 11},
      {3, 5, 1},
      {17, 17, 20},
      {14, 14, 15},
      {16, 11, 9},
      {15, 12, 1},
      {16, 4, 8},
      {4, 19, 5},
      {4, 11, 2},
      {10, 14, 4},
      {15, 12, 4},
      {17, 9, 12},
      {6, 4, 13},
      {15, 8, 15},
    };
    int[][] input2 = {{7, 6, 2}};
    PaintHouses p = new PaintHouses();
    System.out.println(p.minCostDP(input2));
    System.out.println(p.minCostDP(input));
  }
}

package main.java.leetcode.Array;

import java.util.Arrays;

public class NumCandies {
  /**
   * Problem: https://leetcode.com/problems/distribute-candies-to-people/
   *
   * @param candies
   * @param num_people
   * @return
   */
  public static int[] distributeCandies(int candies, int num_people) {
    int[] candiesArray = new int[num_people];
    int counter = 1;
    int multiplier = 0;
    while (candies != 0) {
      int candiesToHandout = counter + (multiplier * num_people);
      if (candiesToHandout > candies) {
        candiesArray[counter - 1] += candies;
        candies -= candies;
      } else {
        candiesArray[counter - 1] += candiesToHandout;
        candies -= candiesToHandout;
        if (counter % num_people == 0) {
          counter = 1;
          multiplier++;
        } else {
          counter++;
        }
      }
    }
    return candiesArray;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(distributeCandies(7, 4)));
  }
}

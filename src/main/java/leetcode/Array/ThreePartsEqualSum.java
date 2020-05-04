package main.java.leetcode.Array;

public class ThreePartsEqualSum {
  public static boolean canThreePartsEqualSum(int[] arr) {
    for (int i = 0; i < arr.length - 2; i++) {
      int partOneSum = 0;
      boolean isPartTwoSumAvailable = false;
      // part 1 sum
      // TODO: Possibility of using a bit of DP here
      for (int j = 0; j <= i; j++) {
        partOneSum += arr[j];
      }

      // part 2 sum
      int partTwoCounter = i + 1;
      int partTwoSum = 0;
      while (partTwoCounter <= arr.length - 2) {
        partTwoSum += arr[partTwoCounter];
        if (partOneSum == partTwoSum) {
          isPartTwoSumAvailable = true;
          break;
        }
        partTwoCounter++;
      }

      // part 3 sum
      if (isPartTwoSumAvailable) {
        int partThreeSum = 0;
        for (int k = partTwoCounter + 1; k < arr.length; k++) {
          partThreeSum += arr[k];
        }

        if (partTwoSum == partThreeSum) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {2, 2, 2};
    System.out.println(canThreePartsEqualSum(arr));
  }
}

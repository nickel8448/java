package main.java.leetcode.Array;

class SmallestDifference {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    int[] solution = new int[2];
    int smallestDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arrayOne.length; i++) {
      for (int j = 0; j < arrayTwo.length; j++) {
        int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
        if (diff < smallestDiff) {
          solution[0] = arrayOne[i];
          solution[1] = arrayTwo[j];
          smallestDiff = diff;
        }
      }
    }
    return solution;
  }
}

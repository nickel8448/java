package main.java.leetcode.Array;

import java.util.List;

public class MoveElementToEnd {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int startPointer = 0;
    int endPointer = array.size() - 1;
    while (startPointer < endPointer) {
      while (startPointer < endPointer && array.get(endPointer) == toMove) {
        endPointer--;
      }
      if (array.get(startPointer) == toMove) {
        swap(startPointer, endPointer, array);
      }
      startPointer++;
    }
    return array;
  }

  private static void swap(int left, int right, List<Integer> array) {
    int temp = array.get(left);
    array.set(left, array.get(right));
    array.set(right, temp);
  }
}

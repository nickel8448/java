package main.java.leetcode.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestCommonElement {
  /**
   * Problem: https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
   *
   * @param mat
   * @return
   */
  public int smallestCommonElement(int[][] mat) {
    List<Integer> presentElements = new ArrayList<>();
    for (int i = 0; i < mat[0].length; i++) {
      ArrayList<Integer> currentElementList = new ArrayList<>();
      for (int j = 1; j < mat.length; j++) {
        currentElementList.add(isPresent(mat[j], mat[0][i]));
      }
      if (!currentElementList.contains(-1)) {
        presentElements.add(currentElementList.get(0));
      }
    }
    if(presentElements.size() != 0)
        return Collections.min(presentElements);
    else
        return -1;
  }

  private int isPresent(int[] arr, int num) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == num) {
        return arr[mid];
      } else {
        if (arr[mid] > num) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4, 6},
            {2, 4, 5, 8, 10},
            {1, 5, 7, 9, 11},
            {1, 2, 3, 5, 9}
        };
        SmallestCommonElement s = new SmallestCommonElement();
        System.out.println(s.smallestCommonElement(mat));

    }
}

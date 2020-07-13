package main.java.leetcode.Array;

import java.util.Comparator;
import java.util.TreeMap;

public class MinimumDominoRotation {

  private class Node {
    int number;
    int frequency;
    char arr;

    Node(int number, int frequency, char arr) {
      this.number = number;
      this.frequency = frequency;
      this.arr = arr;
    }
  }

  public int minDominoRotations(int[] A, int[] B) {
    TreeMap<Node, Integer> map =
        new TreeMap<>(
            new Comparator<Node>() {
              public int compare(Node n1, Node n2) {
                return n2.frequency - n1.frequency;
              }
            });
    for (int i = 0; i < A.length; i++) {}
    return 0;
  }
}

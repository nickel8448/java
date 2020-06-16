package main.java.leetcode.Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Input: [3,3,3,1,2,1,1,2,3,3,4] Output: 5 Explanation: We can collect [1,2,1,1,2]. If we started
 * at the first tree or the eighth tree, we would only collect 4 fruits.
 */
public class FruitIntoBaskets {
  private static class Node {
    int num;
    int count;

    Node(int num) {
      this.num = num;
    }

    Node(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }

  public static int totalFruit(int[] tree) {
    Set<Integer> uniqueFruits = new HashSet<>();
    LinkedList<Node> blocks = new LinkedList<>();
    for (int i = 0; i < tree.length; i++) {
      if (i != 0 && tree[i] == tree[i - 1] && !blocks.isEmpty()) {
        blocks.peekLast().count++;
      } else {
        blocks.add(new Node(tree[i], 1));
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    totalFruit(tree);
  }
}

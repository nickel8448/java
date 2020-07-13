package main.java.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: [3,3,3,1,2,1,1,2,3,3,4] Output: 5 Explanation: We can collect [1,2,1,1,2]. If we started
 * at the first tree or the eighth tree, we would only collect 4 fruits.
 */
public class FruitIntoBaskets {
  private static class Node {
    int num;
    int count;

    Node(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }

  public static int totalFruit(int[] tree) {
    int n = tree.length;
    Map<Integer, Integer> fruits = new HashMap<Integer, Integer>();
    int lower = 0;
    int upper = 0;
    int ans = 0;

    while (upper < n) {
      if (fruits.size() <= 2) {
        fruits.put(tree[upper], fruits.getOrDefault(tree[upper], 0) + 1);
        upper++;
      }

      if (fruits.size() == 3) {
        fruits.put(tree[lower], fruits.get(tree[lower]) - 1);
        if (fruits.get(tree[lower]) == 0) fruits.remove(tree[lower]);
        lower++;
      }
      ans = Math.max(ans, upper - lower);
    }
    return ans;
  }

  // public static int totalFruit(int[] tree) {
  //   Set<Integer> uniqueFruits = new HashSet<>();
  //   int maxFruits = Integer.MIN_VALUE;
  //   LinkedList<Node> blocks = new LinkedList<>();
  //   for (int i = 0; i < tree.length; i++) {
  //     if (i != 0 && tree[i] == tree[i - 1] && !blocks.isEmpty()) {
  //       blocks.peekLast().count++;
  //     } else {
  //       blocks.add(new Node(tree[i], 1));
  //     }
  //   }
  //   int numFruits = 0;
  //   for (int i = 0; i < blocks.size(); i++) {
  //     uniqueFruits.add(blocks.get(i).num);
  //     if (uniqueFruits.size() > 2) {
  //       numFruits = blocks.get(i - 1).count;
  //       uniqueFruits.remove(blocks.get(i - 2).num);
  //     }
  //     numFruits += blocks.get(i).count;
  //     if (numFruits > maxFruits) maxFruits = numFruits;
  //   }
  //   return maxFruits;
  // }

  public static void main(String[] args) {
    int[] tree = {5, 0, 0, 7, 0, 7, 2, 7};
    System.out.println(totalFruit(tree));
  }
}

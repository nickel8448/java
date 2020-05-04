package main.java.leetcode.Array;

import java.util.ArrayList;

public class FindMinimumFiboNumbers {
  static int numNumbers = 0;

  public static int findMinFibonacciNumbers(int k) {
    ArrayList<Integer> fibNumbers = new ArrayList<>();
    fibTerms(fibNumbers, k);
    int count = 0, j = fibNumbers.size() - 1;
    while (k > 0) {
      count += (k / fibNumbers.get(j));
      k %= (fibNumbers.get(j));
      j--;
    }
    return count;
  }

  public static void fibTerms(ArrayList<Integer> list, int k) {
    int counter = 3, term = 0;
    list.add(0);
    list.add(1);
    list.add(1);
    while (true) {
      term = list.get(counter - 1) + list.get(counter - 2);
      if (term > k) return;
      list.add(term);
      counter++;
    }
  }

  public static void backtracking(int sum, int k, int counter, ArrayList<Integer> fibNumbers) {
    if (k == sum) {
      numNumbers++;
    } else if (sum > k) {
      return;
    } else if (counter > fibNumbers.size()) {
      return;
    } else {
      for (int i = 0; i < fibNumbers.size(); i++) {
        sum += fibNumbers.get(counter);
        backtracking(sum, k, counter++, fibNumbers);
        sum -= fibNumbers.get(counter);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(findMinFibonacciNumbers(10));
  }
}

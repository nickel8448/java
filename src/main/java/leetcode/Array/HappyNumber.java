package main.java.leetcode.Array;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public static boolean isHappy(int n) {
    if (n == 0) return false;
    if (n == 1) return true;
    Set<Integer> seenNumbers = new HashSet<>();
    while (n != 0) {
      int newNumber = 0;
      int currentNumber = n;
      while (currentNumber != 0) {
        newNumber += (int) Math.pow(currentNumber % 10, 2);
        currentNumber /= 10;
      }
      if (newNumber == 1) return true;
      if (seenNumbers.contains(newNumber)) return false;
      seenNumbers.add(newNumber);
      n = newNumber;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isHappy(18));
  }
}

package main.java.leetcode.BitManipulation;

public class HasAlternatingBits {
  /**
   * Problem: https://leetcode.com/problems/binary-number-with-alternating-bits/ 9/4/2020
   *
   * @param num
   * @return
   */
  public static boolean hasAlternatingBits(int num) {
    int temp = num;
    int counter = 0;
    int runningBit = 0;
    while (temp != 0) {
      if (counter == 0) {
        runningBit = (temp & 1);
        temp >>= 1;
      } else {
        int currentBit = (temp & 1);
        if (currentBit == runningBit) {
          return false;
        } else {
          runningBit = currentBit;
        }
        temp >>= 1;
      }
      counter++;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(hasAlternatingBits(1));
  }
}

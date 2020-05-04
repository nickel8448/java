package main.java.leetcode.BitManipulation;

public class CountSetBits {
  public static int setBits(int n) {
    int numSet = 0;
    int temp = n;
    while (temp != 0) {
      if ((temp & 1) == 1) numSet++;
      temp >>= 1;
    }
    return numSet;
  }

  public static void main(String[] args) {
    System.out.println(setBits(10));
  }
}

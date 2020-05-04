package main.java.leetcode.BitManipulation;

public class HammingWeight {
  public static int hammingWeight(long n) {
    int numOneBits = 0;
    int bit = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & bit) != 0) numOneBits++;
      bit <<= 1;
    }
    return numOneBits;
  }

  public static void main(String[] args) {}
}

package main.java.leetcode.BitManipulation;

public class ComplementOfBaseTen {
  public int bitwiseComplement(int N) {
    int todo = N;
    int bit = 1;
    while (todo != 0) {
      N = N ^ bit;
      bit <<= 1;
      todo >>= 1;
    }
    return N;
  }

  public static void main(String[] args) {}
}

package main.java.leetcode.BitManipulation;

public class NumberComplement {
  public static int findComplement(int num) {
    int todo = num;
    int bit = 1;
    while (todo != 0) {
      num = num ^ bit;
      bit <<= 1;
      todo >>= 1;
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(findComplement(5));
  }
}

package main.java.leetcode.Nums;

public class EucleadiansAlgorithm {
  public static int gcd(int x, int y) {
    if (y > x) gcd(y, x);
    if (x % y == 0) return y;
    return gcd(y, x % y);
  }

  public static void main(String[] args) {
    System.out.println(gcd(1785, 546));
  }
}

package main.java.leetcode.Nums;

public class CountPrimes {
  /** Problem: https://leetcode.com/problems/count-primes/ */
  public static int countPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    int numPrimes = 0;
    for (int i = 2; i < n; i++) {
      if (!notPrime[i]) {
        numPrimes++;
        for (int j = 2; j * i < n; j++) {
          notPrime[j * i] = true;
        }
      }
    }
    return numPrimes;
  }

  public static void main(String[] args) {
    System.out.println(countPrimes(5));
  }
}

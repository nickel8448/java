package main.java.leetcode.Nums;


public class CountBits {
  /**
   * https://leetcode.com/problems/counting-bits/ Every power of two will only have one set bit. eg
   * 1, 2, 4, 8 have all only one set bit
   *
   * @param num
   * @return
   */
  public static int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      result[i] = numOneBits(i);
    }
    return result;
  }

  private static int numOneBits(int num) {
    int setBits = 0;
    String str = Integer.toBinaryString(num);
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') setBits++;
    }
    return setBits;
  }

  public static int[] countBitsDP(int num) {
    int[] result = new int[num + 1];
    int p = 1;
    int pow = 1;
    for (int i = 1; i <= num; i++) {
      if (i == pow) {
        result[i] = 1;
        pow <<= 1;
        p = 1;
      } else {
        result[i] = result[p] + 1;
        p++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] setBits = countBits(100);
    for (int i = 0; i < setBits.length; i++) {
      System.out.println(i + ": " + setBits[i]);
    }
  }
}

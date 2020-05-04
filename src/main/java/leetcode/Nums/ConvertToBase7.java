package main.java.leetcode.Nums;

public class ConvertToBase7 {
  public String convertToBase7(int sum) {
    if (sum == 0) return "0";
    boolean isNegative = false;
    if (sum < 0) {
      isNegative = true;
      sum = Math.abs(sum);
    }
    StringBuilder str = new StringBuilder();
    while (sum != 0) {
      str.append(sum % 7);
      sum /= 7;
    }
    return isNegative ? "-" + str.reverse().toString() : str.reverse().toString();
  }
}

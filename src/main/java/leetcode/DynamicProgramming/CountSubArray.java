package main.java.leetcode.DynamicProgramming;

public class CountSubArray {
  public static int countSubarrays(int[] arr, int k) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = arr[i];
      if (sum == k) {
        count++;
      } else {
        for (int j = i + 1; j < arr.length; j++) {
          sum += arr[j];
          if (sum == k) {
            count++;
            break;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, -1, 1};
    System.out.println(countSubarrays(arr, 0));
  }
}

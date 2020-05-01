package main.java.leetcode.Nums;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        long num = 1;
        while(true) {
            if(num > n) return false;
            else if(num == n) return true;
            num = num << 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1073741825));
    }
}

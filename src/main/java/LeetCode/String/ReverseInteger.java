package main.java.LeetCode.String;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/

public class ReverseInteger {
    public static int reverse(int x) {
        boolean isNeg = x < 0;
        if (isNeg) x *= -1;

        long reversed = 0;
        while(x > 0) {
            int num = x % 10;
            reversed = (reversed * 10) + num;
            x /= 10;
        }
        if(reversed > Integer.MAX_VALUE) return 0;
        return (int) (isNeg ? reversed *= -1 : reversed);
    }

    public static void main(String[] args) {
        System.out.println(reverse(-100));
    }
}

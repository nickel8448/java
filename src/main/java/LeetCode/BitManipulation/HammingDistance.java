package main.java.leetcode.BitManipulation;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int xorOfElements = x ^ y;
        int numberOfDifferentBits = 0;
        while(xorOfElements > 0) {
            numberOfDifferentBits += xorOfElements & 1;
            xorOfElements >>= 1;
        }
        return numberOfDifferentBits;
    }

    public static void main(String[] args) {
        int x = 0;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }
}

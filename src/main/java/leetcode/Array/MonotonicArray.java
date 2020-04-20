package main.java.leetcode.Array;

public class MonotonicArray {
    /**
     * Problem: https://leetcode.com/problems/monotonic-array/
     * 18/4/2020
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        boolean isIncreasing = false, isDecreasing = false;
        for(int i = 1; i < A.length; i++) {
            if(!isIncreasing && !isDecreasing) {
                if(A[i] > A[i - 1]) {
                    isIncreasing = true;
                } else if (A[i] < A[i - 1]) {
                    isDecreasing = true;
                }
            } else if(isIncreasing) {
                if(A[i-1] > A[i]) return false;
            } else {
                if(A[i-1] < A[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

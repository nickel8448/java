package main.java.leetcode.Array;

import java.util.Arrays;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] arr) {
        int[][] outputArray = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            int[] reversedRow = reverseRow(arr[i]);
            int[] inversedRow = inverseRow(reversedRow);
            outputArray[i] = inversedRow;
        }
        return outputArray;
    }

    public static int[] inverseRow(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
        }
        return arr;
    }

    public static int[] reverseRow(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            int y = arr.length - i - 1;
            swap(i, y, arr);
        }
        return arr;
    }

    public static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0};
        reverseRow(arr);
        System.out.println(Arrays.toString(arr));
    }
}

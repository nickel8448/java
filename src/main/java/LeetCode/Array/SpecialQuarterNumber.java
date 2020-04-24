package main.java.leetcode.Array;

public class SpecialQuarterNumber {
    public static int findSpecialInteger(int[] arr) {
        int quarter = arr.length / 4;
        int count = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
                if(count > quarter)
                    return arr[i];
            } else {
                count = 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger(nums));
    }
}

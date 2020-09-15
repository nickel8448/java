package main.java.interview_prep;

import java.util.Arrays;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int[] auxArray = nums.clone();
        Arrays.sort(auxArray);
        for (int i = 1; i < nums.length; i++) {
            if (auxArray[i] == auxArray[i - 1])
                return auxArray[i];
        }
        return auxArray[0];
    }
}

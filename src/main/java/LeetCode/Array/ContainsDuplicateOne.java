package main.java.LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateOne {
    public static boolean containsDuplicate(int []nums) {
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int []a = {1, 1, 2};
        System.out.println(containsDuplicate(a));
    }
}

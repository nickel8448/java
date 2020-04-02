package main.java.leetcode.Array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] num1, int[] num2) {
        if(num1.length > num2.length) intersect(num2, num1);
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : num1) m.put(n, m.getOrDefault(n, 0) + 1);
        int k = 0;
        for (int n : num2) {
            int count = m.getOrDefault(n, 0);
            if (count > 0) {
                num1[k++] = n;
                m.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(num1, 0, k);
    }

    /**
     * Problem: https://leetcode.com/problems/intersection-of-two-arrays/solution/
     * Given two arrays, get their intersection
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) nums1Set.add(nums1[i]);
        HashSet<Integer> nums2Set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) nums2Set.add(nums2[i]);
        if(nums2Set.size() > nums1Set.size()) {
            return setIntersection(nums2Set, nums1Set);
        } else {
            return setIntersection(nums1Set, nums2Set);
        }
    }

    public static int[] setIntersection(HashSet<Integer> nums1Set,
                                        HashSet<Integer> nums2Set) {
        int[] outputArray = new int[nums1Set.size()];
        int index = 0;
        for(Integer num : nums1Set) {
            if(nums2Set.contains(num)) {
                outputArray[index++] = num;
            }
        }
        return Arrays.copyOf(outputArray, index);
    }

    /**
     * Problem: https://leetcode.com/problems/intersection-of-two-arrays/solution/
     * Using the inbuilt set functions to get the output and not writing it from
     * scratch
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectionUsingSetsInBuilt(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) nums1Set.add(nums1[i]);
        HashSet<Integer> nums2Set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) nums2Set.add(nums2[i]);
        nums1Set.retainAll(nums2Set);
        int[] outputArray = new int[nums1Set.size()];
        int index = 0;
        for(Integer num : nums1Set) outputArray[index++] = num;
        return outputArray;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        System.out.println(Arrays.toString(intersection(num1, num2)));
    }
}

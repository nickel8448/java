package main.java.leetcode.Array;

import java.util.Arrays;

public class ContainerWithWater {
    /**
     * Brute force approach to the problem
     * @param height
     * @return
     */
    public static int maxAreaBruteForce(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int containerHeight = Math.min(height[i], height[j]);
                int area = width * containerHeight;
                if(area > max)
                    max = area;
            } 
        }
        return max;
    }

    /**
     * Similar question to the previous one but the approach is two pointers
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0; 
        int leftPointer = 0, rightPointer = height.length - 1;
        while(leftPointer < rightPointer) {
            int containerWidth = rightPointer - leftPointer;
            int containerHeight = Math.min(height[leftPointer], height[rightPointer]);
            maxArea = Math.max(maxArea, containerWidth * containerHeight);
            if(height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
            
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,3,2,5,25,24,5};
        System.out.println(maxAreaBruteForce(height));
    }
}

package main.java.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
            for(int j = 0; j <= i; j++) {
                if(i - 1 >= 1 && (j - 1 >= 0 && j < i)) {
                    int elem = 0;
                    elem = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    result.get(i).add(elem);
                } else {
                    result.get(i).add(1);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> result = generate(2);
        System.out.println(result);
    }
}

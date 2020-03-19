package main.java.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecurringDuplications {
    public static char[] removeDuplicates(char[] input) {
        List<Character> output = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            output.add(input[i]);
            while(i + 1 < input.length && input[i] == input[i + 1])
                i++;
        }
        return output.toString().toCharArray();
    }

    public static void main(String[] args) {
        char[] input = {'a', 'c', 'c', 'c', 'f', 'w', 'd', 'd', 'a', 'd', 'r', 'e', 'e', 'e', 'e'};
        removeDuplicates(input);
    }
}

package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UncommonFromSentences {
    /**
     * Problem: https://leetcode.com/problems/uncommon-words-from-two-sentences/
     * @param A
     * @param B
     * @return
     */
    public static String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer stringA = new StringTokenizer(A);
        StringTokenizer stringB = new StringTokenizer(B);
        while(stringA.hasMoreTokens()) {
            String word = stringA.nextToken();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        while(stringB.hasMoreTokens()) {
            String word = stringB.nextToken();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> stringList = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 1) stringList.add(key);
        }
        String[] output = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            output[i] = stringList.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        String A = "apple";
        String B = "banana";
        System.out.println(Arrays.toString(uncommonFromSentences(A, B)));
    }
}

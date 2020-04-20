package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class IndexPairs {
    /**
     * Problem: https://leetcode.com/problems/index-pairs-of-a-string/
     * 18/4/2020
     * @param text
     * @param words
     * @return
     */
    public static int[][] indexPairs(String text, String[] words) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        int resultIndex = 0;
        for(int i = 0; i < words.length; i++) {
            int fromIndexOf = text.indexOf(words[i].charAt(0));
            while(fromIndexOf != -1) {
                if(fromIndexOf + words[i].length() <= text.length()) {
                    String textSubstring = text.substring(fromIndexOf,
                            fromIndexOf + words[i].length());
                    if(words[i].equals(textSubstring)) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(fromIndexOf);
                        temp.add(fromIndexOf + words[i].length() - 1);
                        resultList.add(temp);
                    }
                }
                fromIndexOf = text.indexOf(words[i].charAt(0), fromIndexOf + 1);
            }
        }
        resultList.sort(new Comparator<>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0).compareTo(o2.get(0)) == 0)
                    return o1.get(1).compareTo(o2.get(1));
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        int[][] outputArray = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            outputArray[i][0] = resultList.get(i).get(0);
            outputArray[i][1] = resultList.get(i).get(1);
        }
        return outputArray;
    }

    public static void main(String[] args) {
        String s = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode"};
        String s2 = "ababa";
        String[] words2 = {"aba", "ab"};
        System.out.println(Arrays.deepToString(indexPairs(s2, words2)));
    }
}

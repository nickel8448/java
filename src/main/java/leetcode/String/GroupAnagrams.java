package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> stringMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String currentWord = strs[i];
            char[] chars = currentWord.toCharArray();
            Arrays.sort(chars);
            currentWord = Arrays.toString(chars);
            if(!stringMap.containsKey(currentWord)) {
                stringMap.put(currentWord, new ArrayList());
            }
            stringMap.get(currentWord).add(strs[i]);
        }
        return new ArrayList(stringMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

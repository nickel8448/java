package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class IndexPairsTrie {
    public int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            Trie current = trie;
            for(char c: s.toCharArray()) {
                if(current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie();
                }
                current = current.children[c - 'a'];
            }
            current.isLeaf = true;
        }

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            Trie current = trie;
            char ch = text.charAt(i);
            int j = i;

            while(current.children[ch - 'a'] != null) {
                current = current.children[ch - 'a'];
                if(current.isLeaf)
                    list.add(new int[]{i, j});
                j++;
                if(j == text.length()) break;
                else ch = text.charAt(j);
            }
        }

        int[][] result = new int[list.size()][2];
        int i = 0;
        for(int[] r : list) {
            result[i] = r;
            i++;
        }
        return result;
    }
}

class Trie {
    boolean isLeaf;
    Trie[] children;

    Trie() {
        isLeaf = false;
        children = new Trie[26];
    }
}

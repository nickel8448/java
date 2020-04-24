package main.java.leetcode.String;

import java.util.HashMap;

public class AlienDictionary {
    /**
     * https://leetcode.com/submissions/detail/313861640/
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        search: for(int i = 0; i < words.length - 1; i++) {
            int aCounter = 0;
            int bCounter = 0;
            String wordA = words[i];
            String wordB = words[i+1];
            while(aCounter < wordA.length() && bCounter < wordB.length()) {
                char aChar = wordA.charAt(aCounter++);
                char bChar = wordB.charAt(bCounter++);
                if(orderMap.get(aChar) < orderMap.get(bChar)) {
                    continue search;
                }
                else if(orderMap.get(aChar) > orderMap.get(bChar))
                    return false;
            }
            if(wordA.length() > wordB.length()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}

package main.java.leetcode.String;


public class CountCharacters {
  /**
   * Problem: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
   *
   * @param words
   * @param chars
   * @return
   */
  public static int countCharacters(String[] words, String chars) {

    int[] counts = new int[26];
    int sumLength = 0;
    populateCharArray(counts, chars);
    for (int i = 0; i < words.length; i++) {
      int[] temp = counts.clone();
      for (int j = 0; j < words[i].length(); j++) {
        char ch = words[i].charAt(j);
        temp[ch - 'a']--;
      }
      boolean isFormed = true;
      for (int k = 0; k < temp.length; k++) {
        if (temp[k] < 0) {
          isFormed = false;
          break;
        }
      }
      if (isFormed) sumLength += words[i].length();
    }
    return sumLength;
  }

  public static void populateCharArray(int[] counts, String chars) {
    for (int i = 0; i < chars.length(); i++) {
      counts[chars.charAt(i) - 'a']++;
    }
  }

  public static void main(String[] args) {
    String[] words = {"cat", "bt", "hat", "tree"};
    String chars = "atach";
    System.out.println(countCharacters(words, chars));
  }
}

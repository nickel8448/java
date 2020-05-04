package main.java.leetcode.String;

import java.util.HashMap;

public class SingleRowKeyboard {
  public static int calculateTime(String keyboard, String word) {
    if (keyboard.equals("") || word.equals("")) return 0;
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (int i = 0; i < keyboard.length(); i++) {
      charMap.put(keyboard.charAt(i), i);
    }
    int totalMovement = 0;
    int fingerIndex = 0;
    for (int i = 0; i < word.length(); i++) {
      totalMovement += Math.abs(charMap.get(word.charAt(i)) - fingerIndex);
      fingerIndex = charMap.get(word.charAt(i));
    }
    return totalMovement;
  }

  public static void main(String[] args) {
    String keyboard = "pqrstuvwxyzabcdefghijklmno";
    String word = "";
    System.out.println(calculateTime(keyboard, word));
  }
}

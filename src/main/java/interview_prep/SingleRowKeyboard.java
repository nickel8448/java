package main.java.interview_prep;

import java.util.*;

public class SingleRowKeyboard {
  public int calculateTime(String keyboard, String word) {
    HashMap<Character, Integer> charMap = new HashMap<>(); // Character -> Index
    for (int i = 0; i < keyboard.length(); i++) {
      charMap.put(keyboard.charAt(i), i);
    }
    int time = 0;
    int currentFingerIndex = 0;
    for (int i = 0; i < word.length(); i++) {
      int nextCharIndex = charMap.get(word.charAt(i));
      time += Math.abs(currentFingerIndex - nextCharIndex);
      currentFingerIndex = nextCharIndex;
    }
    return time;
  }
}

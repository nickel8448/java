package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/bulls-and-cows/
 *
 * <p>Invariant: 1) Number of bulls are digits in the guess that are in the correct position 2)
 * Number of cows are digits that are in your secret number but are in wrong position. These can be
 * rearranged so that they become bulls
 */
public class BullsAndCows {
  public String getHint(String secret, String guess) {
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    StringBuilder secretSB = new StringBuilder();
    StringBuilder guessSB = new StringBuilder();
    int numBulls = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        numBulls++;
      } else {
        guessSB.append(guess.charAt(i));
        frequencyMap.put(secret.charAt(i), frequencyMap.getOrDefault(secret.charAt(i), 0) + 1);
      }
    }
    String bullsString = String.valueOf(numBulls) + "A";
    int numCows = 0;
    for (int i = 0; i < guessSB.length(); i++) {
      char guessChar = guessSB.charAt(i);
      if (frequencyMap.containsKey(guessChar)) {
        numCows++;
        if (frequencyMap.get(guessChar) == 1) {
          frequencyMap.remove(guessChar);
        } else {
          frequencyMap.put(guessChar, frequencyMap.get(guessChar) - 1);
        }
      }
    }
    return bullsString + String.valueOf(numCows) + "B";
  }
}

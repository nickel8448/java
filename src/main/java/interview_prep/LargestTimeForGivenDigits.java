package main.java.interview_prep;

import java.util.*;

public class LargestTimeForGivenDigits {
  public String largestTimeFromDigits(int[] arr) {
    List<String> permutations = generatePermutations(arr);
    String result = "";
    for (String permutation : permutations) {
      String HH = permutation.substring(0, 2);
      String MM = permutation.substring(2);
      if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && result.compareTo(HH + ":" + MM) < 0) {
        result = HH + ":" + MM;
      }
    }
    return result;
  }

  private List<String> generatePermutations(int[] arr) {
    String arrString = "";
    for (int num : arr) {
      arrString += num;
    }
    List<String> permutationsList = new ArrayList<>();
    generatePermutationsFromString(arrString, "", permutationsList);
    return permutationsList;
  }

  private void generatePermutationsFromString(
      String s, String sofar, List<String> permutationsList) {
    if (s.isEmpty()) {
      permutationsList.add(sofar);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      generatePermutationsFromString(
          s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), permutationsList);
    }
  }
}

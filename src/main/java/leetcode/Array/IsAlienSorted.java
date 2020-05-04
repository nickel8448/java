package main.java.leetcode.Array;


// "hlabcdefgijkmnopqrstuvwxyz"
// "0, 1, 2, 3, 4, 5, 6,...24, 25"

// ""word","world","row"

public class IsAlienSorted {
  public static boolean isAlienSorted(String[] words, String order) {
    int[] orderArray = new int[26];
    for (int i = 0; i < order.length(); i++) {
      orderArray[order.charAt(i) - 'a'] = i;
    }
    for (int i = 0; i < words.length - 1; i++) {
      if (!compare(words[i], words[i + 1], orderArray)) return false;
    }
    return true;
  }

  public static boolean compare(String wordOne, String wordTwo, int[] orderArray) {
    boolean same = false;
    for (int i = 0; i < wordOne.length() && i < wordTwo.length(); i++) {
      if (wordOne.charAt(i) == wordTwo.charAt(i)) {
        same = true;
        continue;
      } else if (wordOne.charAt(i) != wordTwo.charAt(i)) {
        same = false;
      }
      if (!same) {
        int wordOneCharIndex = orderArray[wordOne.charAt(i) - 'a'];
        int wordTwoCharIndex = orderArray[wordTwo.charAt(i) - 'a'];
        return wordOneCharIndex > wordTwoCharIndex ? false : true;
      }
    }
    if (wordOne.length() > wordTwo.length()) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] words = {"kuvp", "q"};
    String order = "ngxlkthsjuoqcpavbfdermiywz";
    System.out.println(isAlienSorted(words, order));
  }
}

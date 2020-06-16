package main.java.leetcode.String;

public class LetterTilePossibilities {
  static int num = 0;
  public static int numTilePossibilities(String tiles) {
      StringBuilder result = new StringBuilder();
    helper(result, tiles, 0);
    return num;
  }

  public static void helper(StringBuilder result, String str, int index) {
      for(int i = index; i < str.length(); i++) {
          result.append(str.charAt(i));
          System.out.println(result);
          helper(result, str, i + 1);
          result.replace(result.length() - 1, result.length(), "");
    }
  }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("ABC"));
    }
}

package main.java.leetcode.String;

public class GreatestCommonDivisor {
  public String gcdOfStrings(String str1, String str2) {
    String matchingPrefix = getMatchPrefix(str1, str2);
    if (matchingPrefix.equals("")) return "";
    return "";
  }

  private String getMatchPrefix(String str1, String str2) {
    if (str1.length() > str2.length()) getMatchPrefix(str2, str1);
    StringBuilder result = new StringBuilder("");
    // str1 is shorter
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        result.append(str1.charAt(i));
      } else {
        break;
      }
    }
    return result.toString();
  }
}
